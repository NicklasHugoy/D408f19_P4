package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;

public class VectorCommandParameter extends PositionedNode implements CommandParameter {

    public Expression vectorExpression;

    public VectorCommandParameter(int lineNumber, int charNumber, Expression vectorExpression) {
        super(lineNumber, charNumber);
        this.vectorExpression = vectorExpression;
    }

    public VectorCommandParameter(Expression vectorExpression) {
        super(0,0);
        this.vectorExpression = vectorExpression;
    }

    @Override
    public Node[] getChildren() {
        return new Node[]{vectorExpression};
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitVectorCommandParameter(this);
    }

    @Override
    public String toString() {
        return "VectorCommandParameter";
    }
}
