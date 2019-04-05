package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.IValue;

import java.util.Objects;

public class LiteralVector implements Expression, IValue {

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LiteralVector that = (LiteralVector) o;
		return Objects.equals(x, that.x) && Objects.equals(y, that.y) && Objects.equals(z, that.z);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
	}
}
