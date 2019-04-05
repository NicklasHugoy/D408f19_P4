package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.PositionedNode;

import java.util.ArrayList;

public class InEquality extends PositionedNode implements Expression {

    public Expression left;
    public Expression right;

    public InEquality(Expression left, Expression right) {
        super(0,0);
        this.left = left;
        this.right = right;
    }

    public InEquality(int lineNumber, int charNumber, Expression left, Expression right) {
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
        return "InEquality";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitInEquality(this);
    }
}
