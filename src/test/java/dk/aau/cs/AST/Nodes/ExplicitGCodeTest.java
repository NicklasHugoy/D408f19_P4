package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ExpressionEvaluator.BoolValue;
import dk.aau.cs.AST.ExpressionEvaluator.NumValue;
import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.TypeChecking.ISymbolTable;
import dk.aau.cs.AST.TypeChecking.SymbolTable;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.WarningLevel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExplicitGCodeTest {

    @Test
    public void testFillReferences01(){
        Logger.flush();

        ISymbolTable table = new SymbolTable();
        table.openScope();
        table.enterSymbol("myNum", GMMType.Num, new NumValue(500));

        ExplicitGCode gCodeNode = new ExplicitGCode(0,0, "@ G1 X{myNum} @");

        assertEquals("@ G1 X500.0000 @", gCodeNode.fillReferences(table));
    }


    @Test
    public void testFillReferences02(){
        Logger.flush();

        ISymbolTable table = new SymbolTable();
        table.openScope();
        table.enterSymbol("myNum", GMMType.Num, new NumValue(500));
        table.enterSymbol("neirv475_5dW", GMMType.Num, new NumValue(8492.48423));

        ExplicitGCode gCodeNode = new ExplicitGCode(0,0, "@ G1 X{neirv475_5dW} @");

        assertEquals("@ G1 X8492.4842 @", gCodeNode.fillReferences(table));
    }

    @Test
    public void testFillReferences03(){
        Logger.flush();

        ISymbolTable table = new SymbolTable();
        table.openScope();
        table.enterSymbol("myNum", GMMType.Num, new NumValue(500));
        table.enterSymbol("gew___wfwgrw", GMMType.Num, new NumValue(-5));
        table.enterSymbol("neirv475_5dW", GMMType.Num, new NumValue(10485492.48423));

        ExplicitGCode gCodeNode = new ExplicitGCode(0,0, "@ G1 X{neirv475_5dW} Y{gew___wfwgrw} @");

        assertEquals("@ G1 X10485492.4842 Y-5.0000 @", gCodeNode.fillReferences(table));
    }

    @Test
    public void testFillReferences04(){
        Logger.flush();

        ISymbolTable table = new SymbolTable();
        table.openScope();
        table.enterSymbol("myNum", GMMType.Num, new NumValue(500));
        table.enterSymbol("gew___wfwgrw", GMMType.Num, new NumValue(-5));
        table.enterSymbol("neirv475_5dW", GMMType.Num, new NumValue(10485492.48423));

        ExplicitGCode gCodeNode = new ExplicitGCode(0,0, "@ G1 X{nonExistantThing} Y{gew___wfwgrw} @");
        gCodeNode.fillReferences(table);

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }

    @Test
    public void testFillReferences05(){
        Logger.flush();

        ISymbolTable table = new SymbolTable();
        table.openScope();
        table.enterSymbol("myBool", GMMType.Bool, new BoolValue(true));

        ExplicitGCode gCodeNode = new ExplicitGCode(0,0, "@ G1 Y{myBool} @");
        gCodeNode.fillReferences(table);

        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
    }



}