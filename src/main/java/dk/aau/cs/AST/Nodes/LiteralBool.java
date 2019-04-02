package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Node;

import java.util.ArrayList;

public class LiteralBool implements Expression {

    public boolean boolValue;

    public LiteralBool(boolean boolValue) {
        this.boolValue = boolValue;
    }

    @Override
    public Node[] getChildren() {
        return new Node[0];
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitLiteralBool(this);
    }
}
