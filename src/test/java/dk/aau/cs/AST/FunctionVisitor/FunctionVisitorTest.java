package dk.aau.cs.AST.FunctionVisitor;

import dk.aau.cs.AST.ASTGenerator;
import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.Nodes.*;
import dk.aau.cs.AST.TypeChecking.FunctionTable;
import dk.aau.cs.AST.TypeChecking.IFunctionTable;
import dk.aau.cs.AST.TypeChecking.ISymbolTable;
import dk.aau.cs.AST.TypeChecking.SymbolTable;
import dk.aau.cs.Syntax.GMMLexer;
import dk.aau.cs.Syntax.GMMParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStream;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FunctionVisitorTest {

    private IFunctionTable testCode(String code){
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


        //Cultivate the function table
        FunctionVisitor functionVisitor = new FunctionVisitor(functionTable);
        ast.accept(functionVisitor);

        return functionTable;
    }

    @Test
    public void fillingFunctionTableReturnType01(){
        IFunctionTable functionTable = testCode("void func() {}" +
                "num fac(num n){return n * fac(n-1)}");

        FunctionEntry entry = functionTable.retrieveFunction("func");
        assertEquals(GMMType.Void, entry.returnType);
    }

    @Test
    public void fillingFunctionTableReturnType02(){
        IFunctionTable functionTable = testCode("void func() {}" +
                "num fac(num n){return n * fac(n-1)}");

        FunctionEntry entry = functionTable.retrieveFunction("fac");
        assertEquals(GMMType.Num, entry.returnType);
    }

    @Test
    public void fillingFunctionTableParameter01(){
        IFunctionTable functionTable = testCode("void func() {}" +
                "num fac(num n){return n * fac(n-1)}");

        FunctionEntry entry = functionTable.retrieveFunction("func");
        assertEquals(0, entry.parameterTypes.size());
    }
    @Test
    public void fillingFunctionTableParameter02(){
        IFunctionTable functionTable = testCode("void func() {}" +
                "num fac(num n){return n * fac(n-1)}");

        FunctionEntry entry = functionTable.retrieveFunction("fac");
        assertEquals(1, entry.parameterTypes.size());
    }

    @Test
    public void fillingFunctionTableParameter03(){
        IFunctionTable functionTable = testCode("void func() {}" +
                "num fac(num n){return n * fac(n-1)}");

        FunctionEntry entry = functionTable.retrieveFunction("fac");
        assertEquals(GMMType.Num, entry.parameterTypes.get(0));
    }

    @Test
    public void fillingFunctionTable01(){
        IFunctionTable functionTable = testCode("void func() {}" +
                "num fac(num n){return n * fac(n-1)}");

        FunctionEntry entry = functionTable.retrieveFunction("fac");
        assertTrue(entry != null);
    }

    @Test
    public void fillingFunctionTable02(){
        IFunctionTable functionTable = testCode("void func() {}" +
                "num fac(num n){return n * fac(n-1)}");

        FunctionEntry entry = functionTable.retrieveFunction("func");
        assertTrue(entry != null);
    }

}