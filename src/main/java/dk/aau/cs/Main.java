package dk.aau.cs;

import dk.aau.cs.AST.ASTGenerator;
import dk.aau.cs.AST.FunctionVisitor.FunctionVisitor;
import dk.aau.cs.AST.Nodes.Node;
import dk.aau.cs.AST.TreePrinter;
import dk.aau.cs.AST.TypeChecking.*;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.WarningLevel;
import dk.aau.cs.Syntax.GMMLexer;
import dk.aau.cs.Syntax.GMMParser;
import org.antlr.v4.runtime.*;


public class Main {

    public static void main(String[] args){
        CharStream cs = CharStreams.fromString("" +
                "block[]{ \n" +
                "num x = -1.3245 + true \n" +
                "}");

        //Scan and parse code
        GMMLexer lexer = new GMMLexer(cs);
        TokenStream ts = new BufferedTokenStream(lexer);
        GMMParser parser = new GMMParser(ts);

        //Convert parse tree to AST
        ASTGenerator astGenerator = new ASTGenerator();
        Node ast = parser.prog().accept(astGenerator);

        if(Logger.checkForError()){
            PrintLog();
            return;
        }

        //Initialize function and symbol table
        IFunctionTable functionTable = new FunctionTable();
        ISymbolTable symbolTable = new SymbolTable();

        //Cultivate the function table
        FunctionVisitor functionVisitor = new FunctionVisitor(functionTable);
        ast.accept(functionVisitor);

        if(Logger.checkForError()){
            PrintLog();
            return;
        }

        //Type checking
        TypeCheckVisitor typeCheckVisitor = new TypeCheckVisitor(symbolTable, functionTable);
        ast.accept(typeCheckVisitor);

        if(Logger.checkForError()){
            PrintLog();
            return;
        }

        //Print AST
        TreePrinter printer = new TreePrinter(ast);
        printer.Print();
    }

    public static void PrintLog(){
        System.out.println("Compilation failed; printing log");
        Logger.PrintLogs(System.out);
    }
}
