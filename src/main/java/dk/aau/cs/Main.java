package dk.aau.cs;

import dk.aau.cs.AST.ASTGenerator;
import dk.aau.cs.AST.FunctionVisitor.FunctionVisitor;
import dk.aau.cs.AST.Nodes.Node;
import dk.aau.cs.AST.TreePrinter;
import dk.aau.cs.AST.TypeChecking.*;
import dk.aau.cs.CodeGeneration.CodeGeneratorVisitor;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.WarningLevel;
import dk.aau.cs.Syntax.GMMLexer;
import dk.aau.cs.Syntax.GMMParser;
import org.antlr.v4.runtime.*;

import java.io.*;


public class Main {

    public static void main(String[] args) {
        String inputFile = args[0];
        String outputFile = args[0].replace(".gmm", ".gcode");

        try{
        CharStream cs = CharStreams.fromFileName(inputFile);
        Writer writer = new BufferedWriter(new FileWriter(outputFile, false));

        compile(cs, writer);

        writer.flush();
        writer.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public static void compile(CharStream cs, Writer writer){
        //Scan and parse code
        GMMLexer lexer = new GMMLexer(cs);
        TokenStream ts = new BufferedTokenStream(lexer);
        GMMParser parser = new GMMParser(ts);

        //Convert parse tree to AST
        ASTGenerator astGenerator = new ASTGenerator();
        Node ast = parser.prog().accept(astGenerator);

        //Print AST
        TreePrinter printer = new TreePrinter(ast);
        printer.Print();

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



        CodeGeneratorVisitor codeGenerator = new CodeGeneratorVisitor(symbolTable, functionTable, writer);
        ast.accept(codeGenerator);
    }

    public static void PrintLog(){
        System.out.println("Compilation failed; printing log");
        Logger.PrintLogs(System.out);
    }
}
