package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.Nodes.Node;

public abstract class PositionedNode implements Node {
    public final int lineNumber;
    public final int charNumber;

    public PositionedNode(int lineNumber, int charNumber) {
        this.lineNumber = lineNumber;
        this.charNumber = charNumber;
    }
}
