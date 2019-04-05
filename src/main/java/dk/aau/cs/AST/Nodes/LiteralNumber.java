package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.Value;

public class LiteralNumber implements Expression, Value {

    public float value;

    public LiteralNumber(float value) {
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
