package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Node;

public class ID implements Node {
    public String identifier;

    public ID(String identifier) {
        this.identifier = identifier;
    }

        @Override
    public Node[] getChildren() {
        return new Node[0];
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitID(this);
    }
}
