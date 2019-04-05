package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.*;

import java.util.ArrayList;
import java.util.List;

public class IfNode extends PositionedNode implements Statement {
    public Expression predicate;
    public List<Statement> statements;

    public IfNode(Expression predicate, List<Statement> statements) {
        super(0,0);
        this.predicate = predicate;
        this.statements = statements;
    }

    public IfNode(int lineNumber, int charNumber, Expression predicate, List<Statement> statements) {
        super(lineNumber, charNumber);
        this.predicate = predicate;
        this.statements = statements;
    }

    @Override
    public Node[] getChildren() {
        ArrayList<Node> nodes = new ArrayList<>();

        nodes.add(predicate);
        nodes.addAll(statements);

        return nodes.toArray(new Node[0]);
    }

    @Override
    public String toString() {
        return "If";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitIfNode(this);
    }
}
