package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.ASTGenerator;
import dk.aau.cs.AST.FunctionVisitor.FunctionVisitor;
import dk.aau.cs.AST.Nodes.Node;
import dk.aau.cs.ErrorReporting.AssignToWriteProtectedVariableError;
import dk.aau.cs.ErrorReporting.InvalidTypeInLoopRange;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.WarningLevel;
import dk.aau.cs.Syntax.GMMLexer;
import dk.aau.cs.Syntax.GMMParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeCheckVisitorTest {

    public void testCode(String code){
        CharStream cs = CharStreams.fromString(code);

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
    }

    @BeforeEach
    public void beforeEach(){
        Logger.flush();
    }

    @Test
    public void testMismatchedTypeAssign01(){
        
        testCode("block[]{" +
                "num x = 0 " +
                "x = true " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testMismatchedTypeAssign02(){
        
        testCode("block[]{" +
                "num x = 0 " +
                "x = (1,2,3) " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testMismatchedTypeDeclaration(){
        
        testCode("block[]{" +
                "num i = false" +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testMismatchedTypeReturn01(){
        
        testCode("num block(){" +
                "return false " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testMismatchedTypeReturn02(){
        
        testCode("num block(){" +
                "return 0 " +
                "return false " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testUnexpectedReturn(){
        
        testCode("void block(){" +
                "return 1 " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testMismatchedTypeFormalParameters(){
        
        testCode("void block(bool x){" +
                "move X=x " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testMismatchedTypeActualParameters(){
        
        testCode("void block(num x){}" +
                "b[]{" +
                "block(true)" +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testCorrectCode01(){
        
        testCode("void move(vector v){ move X=v.x Y=v.y Z=v.z }" +
                "b[]{" +
                "vector v = (4, 2, 3) " +
                "move(v) " +
                "}");

        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }

    @Test
    public void testCorrectCode02(){
        
        testCode("void move(vector v){ move X=v.x Y=v.y Z=v.z }" +
                "num fac(num n) {if(n==1) {return 1} return fac(n - 1) * n}" +
                "b[]{" +
                "vector v = (4, 2, 3) " +
                "move(v) " +
                "}");

        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }

    @Test
    public void testMismatchedTypeVectorLiteral(){
        
        testCode("void block(){" +
                "vector x = (5, true, 1) " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testMismatchedTypeExpression(){
        
        testCode("num block(){" +
                "return 50 + (5, 3, 2) " +
                "}");
        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testCorrectExpression01(){
        
        testCode("num block(){" +
                "return 1 + 1 " +
                "}");

        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }

    @Test
    public void testCorrectExpression02(){
        
        testCode("num block(){" +
                "return 1 - 1 " +
                "}");

        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }

    @Test
    public void testCorrectExpression03(){
        
        testCode("num block(){" +
                "return 1 * 1 " +
                "}");

        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }

    @Test
    public void testCorrectExpression04(){
        testCode("num block(){" +
                "return 1 / 1 " +
                "}");

        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }

    @Test
    public void testCorrectExpression05(){
        testCode("vector block(){" +
                "return 1 * (1,1,1) " +
                "}");

        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }

    @Test
    public void testCorrectExpression06(){
        testCode("vector block(){" +
                "return (1,1,1) + (1,1,1) " +
                "}");

        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }

    @Test
    public void testCorrectExpression07(){
        testCode("bool block(){" +
                "return true && false " +
                "}");

        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }
    @Test
    public void testCorrectExpression08(){
        testCode("bool block(){" +
                "return 5 == 7 " +
                "}");

        Logger.PrintLogs(System.out);
        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }

    @Test
    public void testIncorrectExpression01(){
        testCode("vector block(){" +
                "return (1,1,1) * (1,1,1) " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testIncorrectExpression02(){
        testCode("vector block(){" +
                "return (1,1,1) / (1,1,1) " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testIncorrectExpression03(){
        testCode("bool block(){" +
                "return false / true " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testIncorrectExpression04(){
        testCode("bool block(){" +
                "return false * true " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testIncorrectExpression05(){
        testCode("bool block(){" +
                "return false - true " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testIncorrectExpression06(){
        testCode("bool block(){" +
                "return false + true " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testIncorrectExpression07(){
        testCode("bool block(){" +
                "return 2 && 5 " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testIncorrectExpression08(){
        testCode("bool block(){" +
                "return (4,3,2) > (4,2,1) " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testIfStatement(){
        testCode("void block(){" +
                "if(3) {} " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testWhileStatement(){
        testCode("void block(){" +
                "while(3) {} " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testVectorComponents(){
        testCode("bool block(){" +
                "vector v = (4 ,3 ,2) " +
                "return v.x " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }


    @Test
    public void testVectorParameter(){
        testCode("b[]{ " +
                "move (5, 2, 3) X=2 " +
                "}");
        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testMultipleParameters(){
        testCode("b[]{" +
                "move X=50 Y=50 X=60 Y=60 " +
                "}");
        assertEquals(2, Logger.flush().size());
    }

    @Test
    public void testLoop_noErrorWhenUsingNums(){
        testCode("b[]{loop(i=2..15){}}");
        assertTrue(Logger.flush().isEmpty());
    }

    @Test
    public void testLoop_noErrorWhenUsingNegativeNums(){
        testCode("b[]{loop(i=2..-15){}}");
        assertTrue(Logger.flush().isEmpty());
    }

    @Test
    public void testLoop_errorWhenUsingBools01(){
        testCode("b[]{loop(i=true..true){}}");
        assertTrue(Logger.flush().get(0) instanceof InvalidTypeInLoopRange);
    }

    @Test
    public void testLoop_errorWhenUsingBools02(){
        testCode("b[]{loop(i=5..true){}}");
        assertTrue(Logger.flush().get(0) instanceof InvalidTypeInLoopRange);
    }

    @Test
    public void testLoop_errorWhenUsingVectors01(){
        testCode("b[]{loop(i=(1,1,1)..(1,1,1)){}}");
        assertTrue(Logger.flush().get(0) instanceof InvalidTypeInLoopRange);
    }

    @Test
    public void testLoop_errorWhenUsingVectors02(){
        testCode("b[]{loop(i=(1,1,1)..5){}}");
        assertTrue(Logger.flush().get(0) instanceof InvalidTypeInLoopRange);
    }

    @Test
    public void testLoop_errorWhenChangingIndex(){
        testCode("b[]{loop(i=1..5){i=2}}");
        assertTrue(Logger.flush().get(0) instanceof AssignToWriteProtectedVariableError);
    }
}