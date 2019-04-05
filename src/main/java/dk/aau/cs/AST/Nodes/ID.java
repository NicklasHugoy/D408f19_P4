package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.PositionedNode;

public class ID extends PositionedNode implements Node {
    public String identifier;

    public ID(String identifier) {
        super(0,0);
        this.identifier = identifier;
    }

    public ID(int lineNumber, int charNumber, String identifier) {
        super(lineNumber, charNumber);
        this.identifier = identifier;
    }

    @Override
    public Node[] getChildren() {
        return new Node[0];
    }

    @Override
    public String toString() {
        return "ID = " + identifier;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitID(this);
    }
}
