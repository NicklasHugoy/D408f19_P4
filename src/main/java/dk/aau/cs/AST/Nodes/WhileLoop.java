package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.*;

import java.util.ArrayList;
import java.util.List;

public class WhileLoop extends PositionedNode implements Statement {

    public Expression expression;
    public List<Statement> statements;

    public WhileLoop(Expression expression, List<Statement> statements) {
        super(0,0);
        this.expression = expression;
        this.statements = statements;
    }

    public WhileLoop(int lineNumber, int charNumber, Expression expression, List<Statement> statements) {
        super(lineNumber, charNumber);
        this.expression = expression;
        this.statements = statements;
    }

    @Override
    public Node[] getChildren() {
        ArrayList<Node> nodes = new ArrayList<>();

        nodes.add(expression);
        nodes.addAll(statements);

        return nodes.toArray(new Node[0]);
    }

    @Override
    public String toString() {
        return "While";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitWhileLoop(this);
    }
}
