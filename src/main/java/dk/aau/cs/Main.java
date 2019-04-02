package dk.aau.cs;

import dk.aau.cs.AST.ASTGenerator;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.TreePrinter;
import dk.aau.cs.Syntax.GMMLexer;
import dk.aau.cs.Syntax.GMMParser;
import dk.aau.cs.Syntax.GMMVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;


public class Main {

    public static void main(String[] args){
        System.out.println("Hello, World!");

        CharStream cs = CharStreams.fromString("function helloworld (num x) {move X=50}" +
                "block[tool : 50 - 1] {" +
                "num x = 50" +
                "while (x != 0){" +
                "helloworld(x)" +
                "x = x - 1" +
                "}" +
                "}");
        GMMLexer lexer = new GMMLexer(cs);
        TokenStream ts = new BufferedTokenStream(lexer);
        GMMParser parser = new GMMParser(ts);

        ASTGenerator astGenerator = new ASTGenerator();
        Node ast = parser.prog().accept(astGenerator);

        TreePrinter printer = new TreePrinter(ast);
        printer.Print();

    }
}
