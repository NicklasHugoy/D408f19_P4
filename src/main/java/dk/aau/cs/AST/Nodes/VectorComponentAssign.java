package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.*;

import java.util.ArrayList;
import java.util.List;

public class VectorComponentAssign extends PositionedNode implements Statement {

    public ID identifier;
    public ID component;
    public Expression expression;

    public VectorComponentAssign(ID identifier, ID component, Expression expression) {
        super(0,0);
        this.identifier = identifier;
        this.component = component;
        this.expression = expression;
    }

    public VectorComponentAssign(int lineNumber, int charNumber, ID identifier, ID component, Expression expression) {
        super(lineNumber, charNumber);
        this.identifier = identifier;
        this.component = component;
        this.expression = expression;
    }

    @Override
    public Node[] getChildren() {
        List<Node> nodes = new ArrayList<>();

        nodes.add(identifier);
        nodes.add(component);
        nodes.add(expression);

        return nodes.toArray(new Node[0]);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitVectorComponentAssign(this);
    }

    @Override
    public String toString() {
        return "Vector Component Assign";
    }
}
