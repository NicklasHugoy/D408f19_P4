package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;

import java.util.ArrayList;

public class And extends PositionedNode implements Expression {

    public Expression left;
    public Expression right;

    public And(Expression left, Expression right) {
        super(0,0);
        this.left = left;
        this.right = right;
    }

    public And(int lineNumber, int charNumber, Expression left, Expression right) {
        super(lineNumber, charNumber);
        this.left = left;
        this.right = right;
    }

    @Override
    public Node[] getChildren() {
        ArrayList<Node> nodes = new ArrayList<>();

        nodes.add(left);
        nodes.add(right);

        return nodes.toArray(new Node[0]);
    }

    @Override
    public String toString() {
        return "And";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitAnd(this);
    }
}
