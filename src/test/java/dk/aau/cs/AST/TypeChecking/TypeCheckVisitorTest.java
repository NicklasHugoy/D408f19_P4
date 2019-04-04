package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.ASTGenerator;
import dk.aau.cs.AST.FunctionVisitor.FunctionVisitor;
import dk.aau.cs.AST.Node;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.WarningLevel;
import dk.aau.cs.Syntax.GMMLexer;
import dk.aau.cs.Syntax.GMMParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStream;
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

    @Test
    public void testMismatchedTypeAssign01(){
        Logger.Flush();
        testCode("block[]{" +
                "num x = 0 " +
                "x = true " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testMismatchedTypeAssign02(){
        Logger.Flush();
        testCode("block[]{" +
                "num x = 0 " +
                "x = (1,2,3) " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testMismatchedTypeDeclaration(){
        Logger.Flush();
        testCode("block[]{" +
                "num i = false" +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testMismatchedTypeReturn01(){
        Logger.Flush();
        testCode("num block(){" +
                "return false " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testMismatchedTypeReturn02(){
        Logger.Flush();
        testCode("num block(){" +
                "return 0 " +
                "return false " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testUnexpectedReturn(){
        Logger.Flush();
        testCode("void block(){" +
                "return 1 " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testMismatchedTypeFormalParameters(){
        Logger.Flush();
        testCode("void block(bool x){" +
                "move X=x " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testMismatchedTypeActualParameters(){
        Logger.Flush();
        testCode("void block(num x){}" +
                "b[]{" +
                "block(true)" +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testCorrectCode01(){
        Logger.Flush();
        testCode("void move(vector v){ move X=v.x Y=v.y Z=v.z }" +
                "b[]{" +
                "vector v = (4, 2, 3) " +
                "move(v) " +
                "}");

        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }

    @Test
    public void testCorrectCode02(){
        Logger.Flush();
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
        Logger.Flush();
        testCode("void block(){" +
                "vector x = (5, true, 1) " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testMismatchedTypeExpression(){
        Logger.Flush();
        testCode("num block(){" +
                "return 50 + (5, 3, 2) " +
                "}");
        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testCorrectExpression01(){
        Logger.Flush();
        testCode("num block(){" +
                "return 1 + 1 " +
                "}");

        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }

    @Test
    public void testCorrectExpression02(){
        Logger.Flush();
        testCode("num block(){" +
                "return 1 - 1 " +
                "}");

        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }

    @Test
    public void testCorrectExpression03(){
        Logger.Flush();
        testCode("num block(){" +
                "return 1 * 1 " +
                "}");

        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }

    @Test
    public void testCorrectExpression04(){
        Logger.Flush();
        testCode("num block(){" +
                "return 1 / 1 " +
                "}");

        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }

    @Test
    public void testCorrectExpression05(){
        Logger.Flush();
        testCode("vector block(){" +
                "return 1 * (1,1,1) " +
                "}");

        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }

    @Test
    public void testCorrectExpression06(){
        Logger.Flush();
        testCode("vector block(){" +
                "return (1,1,1) + (1,1,1) " +
                "}");

        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }

    @Test
    public void testCorrectExpression07(){
        Logger.Flush();
        testCode("bool block(){" +
                "return true && false " +
                "}");

        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }
    @Test
    public void testCorrectExpression08(){
        Logger.Flush();
        testCode("bool block(){" +
                "return 5 == 7 " +
                "}");

        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
    }

    @Test
    public void testIncorrectExpression01(){
        Logger.Flush();
        testCode("vector block(){" +
                "return (1,1,1) * (1,1,1) " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testIncorrectExpression02(){
        Logger.Flush();
        testCode("vector block(){" +
                "return (1,1,1) / (1,1,1) " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testIncorrectExpression03(){
        Logger.Flush();
        testCode("bool block(){" +
                "return false / true " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testIncorrectExpression04(){
        Logger.Flush();
        testCode("bool block(){" +
                "return false * true " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testIncorrectExpression05(){
        Logger.Flush();
        testCode("bool block(){" +
                "return false - true " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testIncorrectExpression06(){
        Logger.Flush();
        testCode("bool block(){" +
                "return false + true " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testIncorrectExpression07(){
        Logger.Flush();
        testCode("bool block(){" +
                "return 2 && 5 " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testIncorrectExpression08(){
        Logger.Flush();
        testCode("bool block(){" +
                "return (4,3,2) > (4,2,1) " +
                "}");

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }








}