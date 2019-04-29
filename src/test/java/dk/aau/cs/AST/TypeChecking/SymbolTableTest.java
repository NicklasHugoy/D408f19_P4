package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.ExpressionEvaluator.BoolValue;
import dk.aau.cs.AST.ExpressionEvaluator.NumValue;
import dk.aau.cs.AST.GMMType;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.Exceptions.WriteProtectedVariableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymbolTableTest {

    ISymbolTable symbolTable;

    @BeforeEach
    void setUp() {
        symbolTable = new SymbolTable();
    }

    @Test
    public void testSingleScoped01(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(50));

        GMMType type = symbolTable.retrieveSymbol("x");

        assertEquals(type, GMMType.Num);
    }

    @Test
    public void testSingleScoped02(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(50.0));

        TypeValuePair typeValuePair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals( (double)typeValuePair.getValue().getValue(), 50.0);
    }

    @Test
    public void testOvershadow01(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(20.0));
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(50.0));


        TypeValuePair typeValuePair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals( (double)typeValuePair.getValue().getValue(), 50.0);
    }

    @Test
    public void testOvershadow02(){
        symbolTable.openScope();
        symbolTable.enterSymbol("y", GMMType.Num, new NumValue(20.0));
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(50.0));


        TypeValuePair typeValuePair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals( (double)typeValuePair.getValue().getValue(), 50.0);
    }

    @Test
    public void testOvershadow03(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(20.0));
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(50.0));
        symbolTable.leaveScope();

        TypeValuePair typeValuePair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals( (double)typeValuePair.getValue().getValue(), 20.0);
    }
    @Test
    public void testRetrieveOld01(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(20.0));
        symbolTable.openScope();


        TypeValuePair typeValuePair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals( (double)typeValuePair.getValue().getValue(), 20.0);
    }

    @Test
    public void testRetrieveOld02(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(20.0));
        symbolTable.openScope();
        symbolTable.openScope();
        symbolTable.openScope();
        symbolTable.openScope();
        symbolTable.openScope();

        TypeValuePair typeValuePair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals( (double)typeValuePair.getValue().getValue(), 20.0);
    }

    @Test
    public void testRetrieveOld03(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(20.0));
        symbolTable.openScope();
        symbolTable.openScope();
        symbolTable.leaveScope();
        symbolTable.openScope();
        symbolTable.leaveScope();
        symbolTable.openScope();
        symbolTable.openScope();

        TypeValuePair typeValuePair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals( (double)typeValuePair.getValue().getValue(), 20.0);
    }

    @Test
    public void testEmpty01(){
        symbolTable.openScope();

        TypeValuePair typeValuePair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals(GMMType.Void, typeValuePair.getType());
    }

    @Test
    public void testEmpty02(){
        symbolTable.openScope();

        TypeValuePair typeValuePair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals(null, typeValuePair.getValue());
    }

    @Test
    public void testEmpty03(){
        symbolTable.openScope();

        GMMType type = symbolTable.retrieveSymbol("x");

        assertEquals(GMMType.Void, type);
    }

    @Test
    public void testEmpty04(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(20.0));
        symbolTable.openScope();

        GMMType type = symbolTable.retrieveSymbolInScope("x");

        assertEquals(GMMType.Void, type);
    }

    @Test
    public void testOverwriting01(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(20.0));
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(5.0));

        TypeValuePair typeValuePair = symbolTable.retrieveSymbolWithValue("x");
        assertEquals(5.0, (double) typeValuePair.getValue().getValue());
    }

    @Test
    public void testOverwriting02(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(20.0));
        symbolTable.enterSymbol("x", GMMType.Bool, new BoolValue(false));

        TypeValuePair typeValuePair = symbolTable.retrieveSymbolWithValue("x");
        assertEquals(GMMType.Bool, typeValuePair.getType());
    }


    @Test
    public void testIsolation01(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(20.0));
        symbolTable.openScope();
        symbolTable.isolateScope();

        TypeValuePair typeValuePair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals(GMMType.Void, typeValuePair.getType());
    }

    @Test
    public void testIsolation02(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(20.0));
        symbolTable.openScope();
        symbolTable.isolateScope();
        symbolTable.leaveScope();

        TypeValuePair typeValuePair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals( (double)typeValuePair.getValue().getValue(), 20.0);
    }

    @Test
    public void testIsolation03(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(20.0));
        symbolTable.openScope();
        symbolTable.isolateScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(50.0));

        TypeValuePair typeValuePair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals(50.0, (double) typeValuePair.getValue().getValue());
    }

    @Test
    public void exceptionWhenSettingWriteProtected(){
        symbolTable.openScope();
        symbolTable.enterWriteProtectedSymbol("x", GMMType.Num);

        assertThrows(WriteProtectedVariableException.class,
                () -> {symbolTable.assignValue("x", new NumValue(7));});
    }

    @Test
    public void valueUnchangedWhenAssigningWriteProtectedVariable(){
        symbolTable.openScope();
        symbolTable.enterWriteProtectedSymbol("x", GMMType.Num);
        symbolTable.assignWriteProtectedValue("x", new NumValue(42));

        assertThrows(
                WriteProtectedVariableException.class,
                () -> {symbolTable.assignValue("x", new NumValue(7));});
        assertEquals(42d, (double) symbolTable.retrieveSymbolWithValue("x").getValue().getValue());
    }
}