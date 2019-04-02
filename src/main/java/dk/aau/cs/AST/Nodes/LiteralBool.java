package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;

public class LiteralBool implements Expression {

    public boolean boolValue;

    public LiteralBool(boolean boolValue) {
        this.boolValue = boolValue;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitLiteralBool(this);
    }
}
