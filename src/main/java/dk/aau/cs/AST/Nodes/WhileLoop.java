package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.Statement;

import java.util.ArrayList;
import java.util.List;

public class WhileLoop implements Statement {

    public Expression expression;
    public List<Statement> statements;

    public WhileLoop(Expression expression, List<Statement> statements) {
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
