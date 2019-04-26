package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;

import java.util.ArrayList;
import java.util.List;

public class Loop extends PositionedNode implements Statement {

	public ID identifier;
	public Expression startExpression;
	public Expression endExpression;
	public List<Statement> statements;

	public Loop(int lineNumber, int charNumber, ID identifier, Expression startExpression, Expression endExpression, List<Statement> statements) {
		super(lineNumber, charNumber);
		this.identifier = identifier;
		this.startExpression = startExpression;
		this.endExpression = endExpression;
		this.statements = statements;
	}

	@Override
	public Node[] getChildren() {
		ArrayList<Node> nodes = new ArrayList<>();

		nodes.add(identifier);
		nodes.add(startExpression);
		nodes.add(endExpression);
		nodes.addAll(statements);

		return nodes.toArray(new Node[0]);
	}

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visitLoop(this);
	}

	@Override
	public String toString() {
		return "Loop";
	}
}
