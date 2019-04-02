package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;

public class LiteralInt implements Expression {

    public int value;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitLiteralInt(this);
    }
}
