package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;

public class And implements Expression {

    public Expression left;
    public Expression right;

    public And(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitAnd(this);
    }
}
