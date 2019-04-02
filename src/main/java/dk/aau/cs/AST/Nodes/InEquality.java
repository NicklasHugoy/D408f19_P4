package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;

public class InEquality implements Expression {

    public Expression left;
    public Expression right;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitInEquality(this);
    }
}
