package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;

public class LiteralVector extends PositionedNode implements Expression {

    public Expression x,y,z;

    public LiteralVector(Expression x, Expression y, Expression z) {
        super(0,0);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public LiteralVector(int lineNumber, int charNumber, Expression x, Expression y, Expression z) {
        super(lineNumber, charNumber);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Node[] getChildren() {
        return new Node[]{x,y,z};
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitLiteralVector(this);
    }

    @Override
    public String toString() {
        return "Vector";
    }
}
