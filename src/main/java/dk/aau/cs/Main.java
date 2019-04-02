package dk.aau.cs;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;


public class Main {

    public static void main(String[] args){
        System.out.println("Hello, World!");

        CharStream cs = CharStreams.fromString("function helloworld () {move X=50}" +
                "function thisIsAwesome(){move X=0 move X=10}");
        GMMLexer lexer = new GMMLexer(cs);
        TokenStream ts = new BufferedTokenStream(lexer);
        GMMParser parser = new GMMParser(ts);

        GMMParser.ProgContext prog = parser.prog();
        FindFunctions functionsFinder = new FindFunctions();

        VisitTree(functionsFinder, prog);

        for(FindFunctions.Func func : functionsFinder.funcs)
            System.out.println(func.identifier + "  with " + func.body.size() + " lines");


    }

    public static void VisitTree(GMMVisitor visitor, ParseTree tree){
        tree.accept(visitor);

        for(int i = 0; i < tree.getChildCount(); i++)
            VisitTree(visitor, tree.getChild(i));
    }

}
