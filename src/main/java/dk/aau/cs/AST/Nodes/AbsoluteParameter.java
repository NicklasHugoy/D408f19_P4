package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.CommandParameter;
import dk.aau.cs.AST.Expression;

public class AbsoluteParameter implements CommandParameter {

    public ID identifier;

    public Expression expression;

    public AbsoluteParameter(ID identifier, Expression expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitAbsoluteParameter(this);
    }
}
