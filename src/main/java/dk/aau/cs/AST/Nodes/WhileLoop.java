package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Statement;

import java.util.List;

public class WhileLoop implements Statement {

    public Expression expression;
    public List<Statement> statements;

    public WhileLoop(Expression expression, List<Statement> statements) {
        this.expression = expression;
        this.statements = statements;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitWhileLoop(this);
    }
}
