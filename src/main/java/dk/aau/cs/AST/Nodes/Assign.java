package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Statement;

public class Assign implements Statement {
    public ID identifier;
    public Expression expression;

    public Assign(ID identifier, Expression expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitAssign(this);
    }
}
