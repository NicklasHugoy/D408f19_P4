package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.*;

import java.util.List;

public class LeftCircle extends PositionedNode implements Statement {
    public List<CommandParameter> parameters;

    public LeftCircle(List<CommandParameter> parameters) {
        super(0,0);
        this.parameters = parameters;
    }

    public LeftCircle(int lineNumber, int charNumber, List<CommandParameter> parameters) {
        super(lineNumber, charNumber);
        this.parameters = parameters;
    }

    @Override
    public Node[] getChildren() {
        return parameters.toArray(new Node[0]);
    }

    @Override
    public String toString() {
        return "Left Circle";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitLeftCircle(this);
    }
}
