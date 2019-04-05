package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.PositionedNode;

import java.util.ArrayList;

public class TypeNode extends PositionedNode implements Node {

    public GMMType type;

    public TypeNode(GMMType type) {
        super(0,0);
        this.type = type;
    }

    public TypeNode(int lineNumber, int charNumber, GMMType type) {
        super(lineNumber, charNumber);
        this.type = type;
    }

    @Override
    public Node[] getChildren() {
        return new Node[0];
    }

    @Override
    public String toString() {
        return "Type = "+type;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitTypeNode(this);
    }
}
