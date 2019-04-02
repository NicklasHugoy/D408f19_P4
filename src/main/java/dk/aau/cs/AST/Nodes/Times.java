package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;

public class Times implements Expression {

    public Expression left;
    public Expression right;

    public Times(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitTimes(this);
    }
}
