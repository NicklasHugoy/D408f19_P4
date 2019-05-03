package dk.aau.cs.AST.CycleDetection;

import dk.aau.cs.AST.ASTGenerator;
import dk.aau.cs.AST.FunctionVisitor.FunctionVisitor;
import dk.aau.cs.AST.Nodes.Node;
import dk.aau.cs.AST.TreePrinter;
import dk.aau.cs.AST.TypeChecking.FunctionTable;
import dk.aau.cs.AST.TypeChecking.IFunctionTable;
import dk.aau.cs.AST.TypeChecking.ISymbolTable;
import dk.aau.cs.AST.TypeChecking.SymbolTable;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.Syntax.GMMLexer;
import dk.aau.cs.Syntax.GMMParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CycleDetectorTest {

    private IFunctionTable getFunctionTable(String code){
        //Scan and parse code
        GMMLexer lexer = new GMMLexer(CharStreams.fromString(code));
        TokenStream ts = new BufferedTokenStream(lexer);
        GMMParser parser = new GMMParser(ts);

        //Convert parse tree to AST
        ASTGenerator astGenerator = new ASTGenerator();
        Node ast = parser.prog().accept(astGenerator);

        //Initialize function and symbol table
        IFunctionTable functionTable = new FunctionTable();

        //Cultivate the function table
        FunctionVisitor functionVisitor = new FunctionVisitor(functionTable);
        ast.accept(functionVisitor);
        return functionTable;
    }

    @Test
    public void testGraphWithCycle(){
        Logger.flush();
        IFunctionTable table = getFunctionTable("void f(){g()} void g(){f()}");
        CycleDetector detector = new CycleDetector(table);
        detector.findCycle();

        assertEquals(1, Logger.flush().size());
    }

    @Test
    public void testGraphWithMultipleCycle(){
        Logger.flush();
        IFunctionTable table = getFunctionTable("void f(){g() g()} void g(){f() f()}");
        CycleDetector detector = new CycleDetector(table);
        detector.findCycle();

        assertEquals(1, Logger.flush().size());
    }

    @Test
    public void testGraphWithNoCycle01(){
        Logger.flush();
        IFunctionTable table = getFunctionTable("void f(){g() g()} void g(){ }");
        CycleDetector detector = new CycleDetector(table);
        detector.findCycle();

        assertEquals(0, Logger.flush().size());
    }

    @Test
    public void testGraphDirectRecursion(){
        Logger.flush();
        IFunctionTable table = getFunctionTable("void f(){g() f()} void g(){ }");
        CycleDetector detector = new CycleDetector(table);
        detector.findCycle();

        assertEquals(1, Logger.flush().size());
    }

    @Test
    public void testGraphLongRecursion(){
        Logger.flush();
        IFunctionTable table = getFunctionTable("void f(){g()} void g(){v()} void v(){d()} void d(){c()} void c(){f()}");
        CycleDetector detector = new CycleDetector(table);
        detector.findCycle();

        assertEquals(1, Logger.flush().size());
    }

    @Test
    public void testGraphTwoCycle(){
        Logger.flush();
        IFunctionTable table = getFunctionTable("void f(){g()} void g(){f()} void v(){d()} void d(){c()} void c(){v()}");
        CycleDetector detector = new CycleDetector(table);
        detector.findCycle();

        assertEquals(1, Logger.flush().size());
    }

}