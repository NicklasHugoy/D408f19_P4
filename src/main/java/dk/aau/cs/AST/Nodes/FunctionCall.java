package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.Statement;

import java.util.ArrayList;
import java.util.List;

public class FunctionCall implements Statement {
    public ID identifier;
    public List<Expression> parameters;

    public FunctionCall(ID identifier, List<Expression> parameters) {
        this.identifier = identifier;
        this.parameters = parameters;
    }

    @Override
    public Node[] getChildren() {
        ArrayList<Node> nodes = new ArrayList<>();

        nodes.add(identifier);
        nodes.addAll(parameters);

        return nodes.toArray(new Node[0]);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitFunctionCall(this);
    }
}
