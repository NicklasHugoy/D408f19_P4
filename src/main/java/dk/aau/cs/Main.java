package dk.aau.cs;

import dk.aau.cs.AST.ASTGenerator;
import dk.aau.cs.AST.FunctionVisitor.FunctionEntry;
import dk.aau.cs.AST.FunctionVisitor.FunctionVisitor;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.TreePrinter;
import dk.aau.cs.Syntax.GMMLexer;
import dk.aau.cs.Syntax.GMMParser;
import dk.aau.cs.Syntax.GMMVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;


public class Main {

    public static void main(String[] args){
        System.out.println("Hello, World!");

        CharStream cs = CharStreams.fromString("num fun(num x){}");
        GMMLexer lexer = new GMMLexer(cs);
        TokenStream ts = new BufferedTokenStream(lexer);
        GMMParser parser = new GMMParser(ts);

        ASTGenerator astGenerator = new ASTGenerator();
        Node ast = parser.prog().accept(astGenerator);

        TreePrinter printer = new TreePrinter(ast);
        printer.Print();
    }
}
