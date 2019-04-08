package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;

import java.util.Objects;

public class LiteralNumber extends PositionedNode implements Expression {

    public double value;

    public LiteralNumber(double value) {
        super(0,0);
        this.value = value;
    }

    public LiteralNumber(int lineNumber, int charNumber, float value) {
        super(lineNumber, charNumber);
        this.value = value;
    }

    @Override
    public Node[] getChildren() {
        return new Node[0];
    }

    @Override
    public String toString() {
        return "Num = " + value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitLiteralNumber(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LiteralNumber that = (LiteralNumber) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
