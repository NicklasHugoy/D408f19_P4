package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Statement;

import java.util.List;

public class IfNode implements Statement {
    public Expression predicate;
    public List<Statement> statements;


    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitIfNode(this);
    }
}
