package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.*;

import java.util.ArrayList;

public class RelativeParameter extends PositionedNode implements CommandParameter {

    public ID identifier;

    public Expression expression;

    public RelativeParameter(ID identifier, Expression expression) {
        super(0,0);
        this.identifier = identifier;
        this.expression = expression;
    }

    public RelativeParameter(int lineNumber, int charNumber, ID identifier, Expression expression) {
        super(lineNumber, charNumber);
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public Node[] getChildren() {
        ArrayList<Node> nodes = new ArrayList<>();

        nodes.add(identifier);
        nodes.add(expression);

        return nodes.toArray(new Node[0]);
    }

    @Override
    public String toString() {
        return "Relative Parameter";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitRelativeParameter(this);
    }
}
