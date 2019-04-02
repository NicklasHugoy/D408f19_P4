package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.Node;

import java.util.ArrayList;

public class TypeNode implements Node {

    public GMMType type;

    public TypeNode(GMMType type) {
        this.type = type;
    }

    @Override
    public Node[] getChildren() {
        return new Node[0];
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitTypeNode(this);
    }
}
