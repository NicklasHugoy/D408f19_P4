package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.PositionedNode;

public class LiteralNumber extends PositionedNode implements Expression {

    public float value;

    public LiteralNumber(float value) {
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
}
