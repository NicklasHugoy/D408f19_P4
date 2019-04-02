package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.CommandParameter;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.Statement;

import java.util.ArrayList;
import java.util.List;

public class RightCircle implements Statement {
    public List<CommandParameter> parameters;

    public RightCircle(List<CommandParameter> parameters) {
        this.parameters = parameters;
    }

    @Override
    public Node[] getChildren() {
        return parameters.toArray(new Node[0]);
    }

    @Override
    public String toString() {
        return "Right Circle";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitRightCircle(this);
    }
}
