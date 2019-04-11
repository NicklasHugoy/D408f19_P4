package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.*;

import java.util.List;

public class Jump extends PositionedNode implements Statement {
    public List<CommandParameter> parameters;

    public Jump(List<CommandParameter> parameters) {
        super(0,0);
        this.parameters = parameters;
    }

    public Jump(int lineNumber, int charNumber, List<CommandParameter> parameters) {
        super(lineNumber, charNumber);
        this.parameters = parameters;
    }

    @Override
    public Node[] getChildren() {
        return parameters.toArray(new Node[0]);
    }

    @Override
    public String toString() {
        return "Jump";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitJump(this);
    }
}
