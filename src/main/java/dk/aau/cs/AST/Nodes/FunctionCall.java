package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.*;

import java.util.ArrayList;
import java.util.List;

public class FunctionCall extends PositionedNode implements FunctionStatement, Expression {
    public ID identifier;
    public List<Expression> parameters;

    public FunctionCall(ID identifier, List<Expression> parameters) {
        super(0, 0);
        this.identifier = identifier;
        this.parameters = parameters;
    }

    public FunctionCall(int lineNumber, int charNumber, ID identifier, List<Expression> parameters) {
        super(lineNumber, charNumber);
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
    public String toString() {
        return "Function Call";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitFunctionCall(this);
    }
}
