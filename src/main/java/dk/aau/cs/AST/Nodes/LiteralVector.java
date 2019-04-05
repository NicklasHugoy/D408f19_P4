package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.Value;

public class LiteralVector implements Expression, Value {

    public Expression x,y,z;

    public LiteralVector(Expression x, Expression y, Expression z) {
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
