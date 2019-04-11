package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.ExpressionEvaluator.BoolValue;
import dk.aau.cs.AST.ExpressionEvaluator.NumValue;
import dk.aau.cs.AST.GMMType;
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

        TypeValuePair pair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals( (double)pair.getValue().getValue(), 50.0);
    }

    @Test
    public void testOvershadow01(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(20.0));
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(50.0));


        TypeValuePair pair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals( (double)pair.getValue().getValue(), 50.0);
    }

    @Test
    public void testOvershadow02(){
        symbolTable.openScope();
        symbolTable.enterSymbol("y", GMMType.Num, new NumValue(20.0));
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(50.0));


        TypeValuePair pair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals( (double)pair.getValue().getValue(), 50.0);
    }

    @Test
    public void testOvershadow03(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(20.0));
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(50.0));
        symbolTable.leaveScope();

        TypeValuePair pair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals( (double)pair.getValue().getValue(), 20.0);
    }
    @Test
    public void testRetrieveOld01(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(20.0));
        symbolTable.openScope();


        TypeValuePair pair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals( (double)pair.getValue().getValue(), 20.0);
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

        TypeValuePair pair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals( (double)pair.getValue().getValue(), 20.0);
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

        TypeValuePair pair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals( (double)pair.getValue().getValue(), 20.0);
    }

    @Test
    public void testEmpty01(){
        symbolTable.openScope();

        TypeValuePair pair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals(GMMType.Void, pair.getType());
    }

    @Test
    public void testEmpty02(){
        symbolTable.openScope();

        TypeValuePair pair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals(null, pair.getValue());
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

        TypeValuePair pair = symbolTable.retrieveSymbolWithValue("x");
        assertEquals(5.0, (double) pair.getValue().getValue());
    }

    @Test
    public void testOverwriting02(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(20.0));
        symbolTable.enterSymbol("x", GMMType.Bool, new BoolValue(false));

        TypeValuePair pair = symbolTable.retrieveSymbolWithValue("x");
        assertEquals(GMMType.Bool, pair.getType());
    }


    @Test
    public void testIsolation01(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(20.0));
        symbolTable.openScope();
        symbolTable.isolateScope();

        TypeValuePair pair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals(GMMType.Void, pair.getType());
    }

    @Test
    public void testIsolation02(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(20.0));
        symbolTable.openScope();
        symbolTable.isolateScope();
        symbolTable.leaveScope();

        TypeValuePair pair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals( (double)pair.getValue().getValue(), 20.0);
    }

    @Test
    public void testIsolation03(){
        symbolTable.openScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(20.0));
        symbolTable.openScope();
        symbolTable.isolateScope();
        symbolTable.enterSymbol("x", GMMType.Num, new NumValue(50.0));

        TypeValuePair pair = symbolTable.retrieveSymbolWithValue("x");

        assertEquals(50.0, (double) pair.getValue().getValue());
    }
}