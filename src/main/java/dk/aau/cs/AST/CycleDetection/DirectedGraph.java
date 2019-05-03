package dk.aau.cs.AST.CycleDetection;

import dk.aau.cs.AST.FunctionVisitor.FunctionEntry;
import dk.aau.cs.AST.Nodes.FunctionCall;
import dk.aau.cs.AST.Nodes.Statement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class DirectedGraph {
    private HashMap<String, List<String>> nodes;

    public DirectedGraph(dk.aau.cs.AST.TypeChecking.IFunctionTable functionTable) {
        this.nodes = new HashMap<>();
        for(FunctionEntry entry : functionTable.retrieveFunctions()){
            ArrayList<String> calls = new ArrayList<>();
            for(Statement statement : entry.getStatements()){
                if(statement instanceof FunctionCall){
                    String newNode = ((FunctionCall)statement).identifier.identifier;
                    if(!calls.contains(newNode)){
                        calls.add(newNode);
                    }
                }
            }

            nodes.put(entry.getId(), calls);
        }
    }

    public Set<String> getNodes(){
        return nodes.keySet();
    }

    public List<String> getCalls(String node){
        if(!nodes.containsKey(node)){
            throw new RuntimeException(node+" not found in directed graph");
        }

        return nodes.get(node);
    }
}
