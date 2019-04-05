package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;

public class Negate extends PositionedNode implements Expression {
    public Expression expression;

    public Negate(Expression expression) {
        super(0,0);
        this.expression = expression;
    }

    public Negate(int lineNumber, int charNumber, Expression expression) {
        super(lineNumber, charNumber);
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
