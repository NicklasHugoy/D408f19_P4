package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;

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
}
