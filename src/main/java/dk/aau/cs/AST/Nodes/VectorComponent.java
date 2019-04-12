package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;

import java.util.ArrayList;
import java.util.List;

public class VectorComponent extends PositionedNode implements Expression {

    public Expression vector;
    public ID component;

    public VectorComponent(Expression vector, ID component) {
        super(0,0);
        this.vector = vector;
        this.component = component;
    }

    public VectorComponent(int lineNumber, int charNumber, Expression vector, ID component) {
        super(lineNumber, charNumber);
        this.vector = vector;
        this.component = component;
    }

    @Override
    public Node[] getChildren() {
        List<Node> nodes = new ArrayList<>();

        nodes.add(vector);
        nodes.add(component);

        return nodes.toArray(new Node[1]);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitVectorComponent(this);
    }

    @Override
    public String toString() {
        return "Access Vector";
    }
}
