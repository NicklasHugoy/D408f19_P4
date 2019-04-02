package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.Statement;

import java.util.ArrayList;
import java.util.List;

public class IfNode implements Statement {
    public Expression predicate;
    public List<Statement> statements;

    public IfNode(Expression predicate, List<Statement> statements) {
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
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitIfNode(this);
    }
}
