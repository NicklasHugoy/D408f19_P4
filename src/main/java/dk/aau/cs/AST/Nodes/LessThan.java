package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Node;

import java.util.ArrayList;

public class LessThan implements Expression {

	public Expression left;
	public Expression right;

	public LessThan(Expression left, Expression right) {
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
		return "LessThan";
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visitLessThan(this);
	}
}
