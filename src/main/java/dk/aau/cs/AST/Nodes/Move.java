package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.CommandParameter;
import dk.aau.cs.AST.Statement;

import java.util.List;

public class Move implements Statement {
    public List<CommandParameter> parameters;


    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitMove(this);
    }
}
