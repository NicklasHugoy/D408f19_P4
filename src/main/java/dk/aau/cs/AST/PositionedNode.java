package dk.aau.cs.AST;

import java.util.Vector;

public abstract class PositionedNode implements Node {
    public final int lineNumber;
    public final int charNumber;

    public PositionedNode(int lineNumber, int charNumber) {
        this.lineNumber = lineNumber;
        this.charNumber = charNumber;
    }
}
