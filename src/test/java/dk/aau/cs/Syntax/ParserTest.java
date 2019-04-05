package dk.aau.cs.Syntax;

import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    GMMParser getParser(CharStream cs) {
        GMMLexer lexer = new GMMLexer(cs);
        TokenStream ts = new BufferedTokenStream(lexer);
        return new GMMParser(ts);
    }


    @Test
    void getRuleNames(){

        CharStream cs = CharStreams.fromString("");
        GMMParser parser = getParser(cs);

        String[] rules = {
            "prog", "functionDef", "blockDef", "formalParameters", "formalParameter",
                    "machineOptions", "machineOption", "scopedStmt", "functionCall", "commandParameter",
                    "parameters", "expression", "logic", "booleanExpr", "expr", "term", "factor"
        };


        assertEquals(Arrays.toString(rules), Arrays.toString(parser.getRuleNames()));
        assertEquals(17, parser.getRuleNames().length);
    }

    @Test
    void getTokenNames(){
        CharStream cs = CharStreams.fromString("vector v = (2,1,3)");
        GMMParser parser = getParser(cs);

    }
}
