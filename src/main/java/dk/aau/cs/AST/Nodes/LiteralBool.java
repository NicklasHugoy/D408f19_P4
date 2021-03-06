package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;

import java.util.Objects;

public class LiteralBool extends PositionedNode implements Expression {

    public boolean boolValue;

    public LiteralBool(boolean boolValue) {
        super(0,0);
        this.boolValue = boolValue;
    }

    public LiteralBool(int lineNumber, int charNumber, boolean boolValue) {
        super(lineNumber, charNumber);
        this.boolValue = boolValue;
    }

    @Override
    public Node[] getChildren() {
        return new Node[0];
    }

    @Override
    public String toString() {
        return "Bool = " + boolValue;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitLiteralBool(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LiteralBool that = (LiteralBool) o;
        return boolValue == that.boolValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(boolValue);
    }
}
