package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;

import java.util.ArrayList;

public class Plus extends PositionedNode implements Expression {

    public Expression left;
    public Expression right;

    public Plus(Expression left, Expression right) {
        super(0,0);
        this.left = left;
        this.right = right;
    }

    public Plus(int lineNumber, int charNumber, Expression left, Expression right) {
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
        return "Plus";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitPlus(this);
    }
}
