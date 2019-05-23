package dk.aau.cs.AST.CycleDetection;

import dk.aau.cs.AST.TypeChecking.IFunctionTable;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.RecursiveFunctionCallError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CycleDetector {

    private DirectedGraph graph;
    private boolean[] isVisited;
    private String[] nodes;
    private HashMap<String, Integer> idMap;
    private List<String> recursiveFunctions;

    private boolean cycleFound;

    public CycleDetector(IFunctionTable functionTable) {
        this.graph = new DirectedGraph(functionTable);
        nodes = graph.getNodes().toArray(new String[0]);
        isVisited = new boolean[nodes.length];
        idMap = new HashMap<>();
        for(int i = 0; i<nodes.length; i++)
            idMap.put(nodes[i], i);

    }

    public void findCycle(){
        cycleFound = false;
        recursiveFunctions = new ArrayList<>();
        for(int i = 0; i<nodes.length && !cycleFound; i++){
            if(isVisited[i])
                continue;

            resetVisited();
            searchNode(i);
        }

        if(cycleFound){
            StringBuilder builder = new StringBuilder();
            builder.append(recursiveFunctions.get(0));
            for(int i = 1; i<recursiveFunctions.size(); i++)
                builder.append("->").append(recursiveFunctions.get(i));

            Logger.Log(new RecursiveFunctionCallError(builder.toString()));
        }
    }

    private void resetVisited() {
        for(int i = 0; i<isVisited.length;i++){
            isVisited[i] = false;
        }
    }

    private void searchNode(int i) {
        isVisited[i] = true;

        List<String> children = graph.getCalls(nodes[i]);
        recursiveFunctions.add(nodes[i]);

        for(String child : children){
            if(cycleFound)
                return;

            int id = idMap.get(child);
            if(isVisited[id]){
                recursiveFunctions.add(child);
                stopSearching();
            }else{
                searchNode(id);
            }
        }
    }

    private void stopSearching(){
        cycleFound = true;
    }


}
