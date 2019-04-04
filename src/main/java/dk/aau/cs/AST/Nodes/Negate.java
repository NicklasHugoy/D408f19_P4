package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Node;

public class Negate implements Expression {
    public Expression expression;

    public Negate(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Node[] getChildren() {
        return new Node[] {expression};
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitNegate(this);
    }

    @Override
    public String toString() {
        return "Negate";
    }
}
