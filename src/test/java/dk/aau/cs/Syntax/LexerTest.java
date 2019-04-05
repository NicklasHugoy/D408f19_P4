package dk.aau.cs.Syntax;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LexerTest {
    GMMLexer getLexer(CharStream cs) {
        return new GMMLexer(cs);
    }


    @Test
    void getRuleName(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        String[] rules = {
                "Return", "Equals", "Plus", "Minus", "Times", "Divide", "And", "Or",
                "Equality", "InEquality", "GreaterThan", "LessThan", "True", "False",
                "INT", "SemiColon", "CommaSeperator", "DotOperator", "Colon", "While",
                "If", "LParan", "RParan", "LSquare", "RSquare", "LCurl", "RCurl", "MoveCommand",
                "LeftCircleCommand", "RightCircleCommand", "Type", "AbsoluteParameter",
                "CommandParameter", "ID", "Letter", "Digit", "WS"
        };

        assertEquals(Arrays.toString(rules), Arrays.toString(lexer.getRuleNames()));
    }

    @Test
    void getChannelName(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        assertEquals("[DEFAULT_TOKEN_CHANNEL, HIDDEN]", Arrays.toString(lexer.getChannelNames()));
    }

    @Test
    void getMode(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        assertEquals("[DEFAULT_MODE]", Arrays.toString(lexer.getModeNames()));
    }

    @Test
    void getFileName(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        assertEquals("GMM.g4", lexer.getGrammarFileName());
    }

    @Test
    void get(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        
    }
}
