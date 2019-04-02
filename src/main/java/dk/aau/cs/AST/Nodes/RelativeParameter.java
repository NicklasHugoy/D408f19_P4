package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.CommandParameter;
import dk.aau.cs.AST.Expression;

public class RelativeParameter implements CommandParameter {

    public ID identifier;

    public Expression expression;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitRelativeParameter(this);
    }
}
