package dk.aau.cs.CodeGeneration;

import dk.aau.cs.AST.ASTGenerator;
import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.FunctionVisitor.FunctionVisitor;
import dk.aau.cs.AST.Nodes.Node;
import dk.aau.cs.AST.TypeChecking.*;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.Syntax.GMMLexer;
import dk.aau.cs.Syntax.GMMParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStream;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.io.Writer;

import static org.junit.jupiter.api.Assertions.*;

class CodeGeneratorVisitorTest {


    public Node compileCode(String code, IFunctionTable functionTable, ISymbolTable symbolTable){
        CharStream cs = CharStreams.fromString(code);

        //Scan and parse code
        GMMLexer lexer = new GMMLexer(cs);
        TokenStream ts = new BufferedTokenStream(lexer);
        GMMParser parser = new GMMParser(ts);

        //Convert parse tree to AST
        ASTGenerator astGenerator = new ASTGenerator();
        Node ast = parser.prog().accept(astGenerator);

        //Cultivate the function table
        FunctionVisitor functionVisitor = new FunctionVisitor(functionTable);
        ast.accept(functionVisitor);

        //Type checking
        TypeCheckVisitor typeCheckVisitor = new TypeCheckVisitor(symbolTable, functionTable);
        ast.accept(typeCheckVisitor);

        return ast;
    }

    @Test
    public void testMoveCommand01(){
        String output = generateCode("b[]{move X=50 Y=20}");

        assertEquals("G1 X50.0000 Y20.0000\n", output);
    }

    @Test
    public void testMoveCommand02(){
        String output = generateCode("b[]{move X=50 Y=20 move Z=100}");

        assertEquals("G1 X50.0000 Y20.0000\nG1 Z100.0000\n", output);
    }

    @Test
    public void testMoveCommand03(){
        String output = generateCode("b[]{num x = 999.2\nmove X=x Y=20 move Z=100}");

        assertEquals("G1 X999.2000 Y20.0000\nG1 Z100.0000\n", output);
    }

    @Test
    public void testWhileCommand01(){
        String output = generateCode("b[]{" +
                "num x = 3 " +
                "while (x > 0) {" +
                "move X=10-x " +
                "num x = x - 1" +
                "}" +
                "}");

        assertEquals("G1 X7.0000\nG1 X8.0000\nG1 X9.0000\n", output);
    }

    @Test
    public void testWhileCommand02(){
        String output = generateCode("b[]{" +
                "num x = 3 " +
                "while (x < 0) {" +
                "move X=10-x " +
                "num x = x - 1" +
                "}" +
                "}");

        assertEquals("", output);
    }

    @Test
    public void testIfCommand01(){
        String output = generateCode("b[]{if(50 == 50.0000){move X=50.1}}");

        assertEquals("G1 X50.1000\n", output);
    }

    @Test
    public void testIfCommand02(){
        String output = generateCode("b[]{if(50 == 50.0001){move X=50.1}}");

        assertEquals("", output);
    }

    @Test
    public void testGCodeCommand01(){
        String output = generateCode("b[]{@ Hello World @}");

        assertEquals("Hello World\n", output);
    }

    @Test
    public void testGCodeCommand02(){
        String output = generateCode("b[]{@ G1 X50 @}");

        assertEquals("G1 X50\n", output);
    }

    @Test
    public void testGCodeCommand03(){
        String output = generateCode("b[]{num myVar = 27 @ G1 Y{myVar} @}");

        assertEquals("G1 Y27.0000\n", output);
    }

    public void testFunction01(){
        String output = generateCode("void moveRec(num n){ " +
                "move X=n" +
                "}" +
                "b[]{" +
                "moveRec(20) " +
                "}");

        assertEquals("G1 X20.0000\n", output);
    }

    public void testFunction02(){
        String output = generateCode("num moveRec(num n){ " +
                "return n+50" +
                "}" +
                "b[]{" +
                "move X=moveRec(20) " +
                "}");

        assertEquals("G1 X70.0000\n", output);
    }






    private String generateCode(String code) {
        IFunctionTable functionTable = new FunctionTable();
        ISymbolTable symbolTable = new SymbolTable();
        Node ast = compileCode(code, functionTable, symbolTable);

        Writer writer = new StringWriter();

        ASTVisitor codeGen = new CodeGeneratorVisitor(symbolTable, functionTable, writer);
        ast.accept(codeGen);
        return writer.toString();
    }

}