package dk.aau.cs.AST;

import dk.aau.cs.AST.Nodes.Node;

public class TreePrinter {
    private Node startNode;
    private String prefix;

    public TreePrinter(Node startNode) {
        this.startNode = startNode;
    }

    public void Print(){
        prefix = "";

        PrintNode(startNode);
    }

    private void PrintNode(Node node){
        System.out.println(prefix +node.toString());
        String old = prefix;
        prefix += "|  ";
        for(Node child : node.getChildren())
            PrintNode(child);
        prefix = old;
    }
}
