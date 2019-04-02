package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.*;

import java.util.ArrayList;
import java.util.List;

public class Variable implements Expression{

    public ID identifier;

    public Variable(ID identifier) {
        this.identifier = identifier;
    }

    @Override
    public Node[] getChildren() {
        ArrayList<Node> nodes = new ArrayList<>();

        nodes.add(identifier);

        return nodes.toArray(new Node[0]);
    }

    @Override
    public String toString() {
        return "Variable";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitVariable(this);
    }
}

