package dk.aau.cs;

import dk.aau.cs.AST.ASTGenerator;
import dk.aau.cs.AST.FunctionVisitor.FunctionVisitor;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.TreePrinter;
import dk.aau.cs.AST.TypeChecking.*;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.Syntax.GMMLexer;
import dk.aau.cs.Syntax.GMMParser;
import org.antlr.v4.runtime.*;


public class Main {

    public static void main(String[] args){
        System.out.println("Hello, World!");

        CharStream cs = CharStreams.fromString("" +
                "num test(num i) { return i } " +
                "block[]{" +
                "vector i = (-2, 3, -5) " +
                "num x = test(x) " +
                "}");

        //Scan and parse code
        GMMLexer lexer = new GMMLexer(cs);
        TokenStream ts = new BufferedTokenStream(lexer);
        GMMParser parser = new GMMParser(ts);

        //Convert parse tree to AST
        ASTGenerator astGenerator = new ASTGenerator();
        Node ast = parser.prog().accept(astGenerator);

        //Initialize function and symbol table
        IFunctionTable functionTable = new FunctionTable();
        ISymbolTable symbolTable = new SymbolTable();

        //Cultivate the function table
        FunctionVisitor functionVisitor = new FunctionVisitor(functionTable);
        ast.accept(functionVisitor);

        //Type checking
        TypeCheckVisitor typeCheckVisitor = new TypeCheckVisitor(symbolTable, functionTable);
        ast.accept(typeCheckVisitor);

        //Print AST
        TreePrinter printer = new TreePrinter(ast);
        printer.Print();

        //Print compiler errors / warnings
        PrintLog();
    }

    public static void PrintLog(){
        System.out.println("Logger output");
        Logger.PrintLogs(System.out);
    }
}
