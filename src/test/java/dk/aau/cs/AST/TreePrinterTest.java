package dk.aau.cs.AST;

import dk.aau.cs.AST.Nodes.Node;
import dk.aau.cs.ErrorReporting.WarningLevel;
import dk.aau.cs.Syntax.GMMLexer;
import dk.aau.cs.Syntax.GMMParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreePrinterTest {

    ASTGenerator astGenerator;
    @BeforeEach
    void setUp() {
        astGenerator = new ASTGenerator();
    }


    GMMParser getParser(CharStream cs) {
        GMMLexer lexer = new GMMLexer(cs);
        TokenStream ts = new BufferedTokenStream(lexer);
        return new GMMParser(ts);
    }
    @Test
    void treePrinter(){
        CharStream cs = CharStreams.fromString("block[tool:0, bound_x:200]{ move X=2 Y=5 leftCircle X=5 R=2}");
        GMMParser parser = getParser(cs);
        Node node = astGenerator.visitProg(parser.prog());
        TreePrinter tp = new TreePrinter(node);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        tp.Print();

        String expected = "Program\r\n" +
                "|  Block definition\r\n" +
                "|  |  MachineOption\r\n" +
                "|  |  |  ID = tool\r\n" +
                "|  |  MachineOption\r\n" +
                "|  |  |  ID = bound_x\r\n" +
                "|  |  Move\r\n" +
                "|  |  |  Relative Parameter\r\n" +
                "|  |  |  |  ID = X\r\n" +
                "|  |  |  |  Num = 2.0\r\n" +
                "|  |  |  Relative Parameter\r\n" +
                "|  |  |  |  ID = Y\r\n" +
                "|  |  |  |  Num = 5.0\r\n" +
                "|  |  Left Circle\r\n" +
                "|  |  |  Relative Parameter\r\n" +
                "|  |  |  |  ID = X\r\n" +
                "|  |  |  |  Num = 5.0\r\n" +
                "|  |  |  Relative Parameter\r\n" +
                "|  |  |  |  ID = R\r\n" +
                "|  |  |  |  Num = 2.0\r\n";

        assertEquals(expected, outContent.toString());
    }
}
