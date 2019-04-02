package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Statement;

public class Declaration implements Statement {
    public TypeNode type;
    public ID identifier;
    public Expression expression;

    public Declaration(TypeNode type, ID identifier, Expression expression) {
        this.type = type;
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitDeclaration(this);
    }
}
