package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.CommandParameter;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.Statement;

import java.util.List;

public class Move implements Statement {
    public List<CommandParameter> parameters;

    public Move(List<CommandParameter> parameters) {
        this.parameters = parameters;
    }


    @Override
    public Node[] getChildren() {
        return parameters.toArray(new Node[0]);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitMove(this);
    }
}
