package dk.aau.cs.AST.CycleDetection;

import dk.aau.cs.AST.FunctionVisitor.FunctionEntry;
import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.Nodes.FunctionCall;
import dk.aau.cs.AST.Nodes.ID;
import dk.aau.cs.AST.Nodes.LiteralNumber;
import dk.aau.cs.AST.Nodes.ReturnNode;
import dk.aau.cs.AST.TypeChecking.FunctionTable;
import dk.aau.cs.AST.TypeChecking.IFunctionTable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DirectedGraphTest {

    @Test
    public void testDirectedGraphConstructor01(){
        IFunctionTable functionTable = new FunctionTable();
        functionTable.enterFunction(new FunctionEntry("f", GMMType.Void, new ArrayList<>(), new ArrayList<>(){{add(new FunctionCall(new ID("g"), new ArrayList<>()));}}, new ArrayList<>()));
        functionTable.enterFunction(new FunctionEntry("g", GMMType.Void, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        DirectedGraph graph = new DirectedGraph(functionTable);

        assertEquals(new ArrayList<String>(){{add("g");}}, graph.getCalls("f"));
    }

    @Test
    public void testDirectedGraphConstructor02(){
        IFunctionTable functionTable = new FunctionTable();
        functionTable.enterFunction(new FunctionEntry("f", GMMType.Void, new ArrayList<>(), new ArrayList<>(){{add(new FunctionCall(new ID("g"), new ArrayList<>()));}}, new ArrayList<>()));
        functionTable.enterFunction(new FunctionEntry("g", GMMType.Void, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        DirectedGraph graph = new DirectedGraph(functionTable);

        assertEquals(new ArrayList<String>(), graph.getCalls("g"));
    }

    @Test
    public void testDirectedGraphConstructor03(){
        IFunctionTable functionTable = new FunctionTable();
        functionTable.enterFunction(new FunctionEntry("f", GMMType.Void, new ArrayList<>(), new ArrayList<>(){{add(new FunctionCall(new ID("g"), new ArrayList<>()));add(new FunctionCall(new ID("f"), new ArrayList<>()));}}, new ArrayList<>()));
        functionTable.enterFunction(new FunctionEntry("g", GMMType.Void, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        DirectedGraph graph = new DirectedGraph(functionTable);

        assertEquals(new ArrayList<String>(){{add("g");add("f");}}, graph.getCalls("f"));
    }

}