package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.PositionedNode;

import java.util.ArrayList;

public class FormalParameter extends PositionedNode implements Node {

    public TypeNode type;
    public ID identifier;

    public FormalParameter(TypeNode type, ID identifier) {
        super(0,0);
        this.type = type;
        this.identifier = identifier;
    }

    public FormalParameter(int lineNumber, int charNumber, TypeNode type, ID identifier) {
        super(lineNumber, charNumber);
        this.type = type;
        this.identifier = identifier;
    }

    @Override
    public Node[] getChildren() {
        ArrayList<Node> nodes = new ArrayList<>();

        nodes.add(type);
        nodes.add(identifier);

        return nodes.toArray(new Node[0]);
    }

    @Override
    public String toString() {
        return "Formal Parameter";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitFormalParameter(this);
    }
}
