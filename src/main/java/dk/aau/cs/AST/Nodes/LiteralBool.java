package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.Value;

import java.util.ArrayList;

public class LiteralBool implements Expression, Value {

    public boolean boolValue;

    public LiteralBool(boolean boolValue) {
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
