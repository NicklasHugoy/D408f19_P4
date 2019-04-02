package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.CommandParameter;
import dk.aau.cs.AST.Statement;

import java.util.List;

public class RightCircle implements Statement {
    public List<CommandParameter> parameters;

    public RightCircle(List<CommandParameter> parameters) {
        this.parameters = parameters;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitRightCircle(this);
    }
}
