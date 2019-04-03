package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Node;

import java.util.ArrayList;
import java.util.List;

public class VectorComponent implements Expression {

    public ID identifier;
    public ID component;

    public VectorComponent(ID identifier, ID component) {
        this.identifier = identifier;
        this.component = component;
    }

    @Override
    public Node[] getChildren() {
        List<Node> nodes = new ArrayList<>();

        nodes.add(identifier);
        nodes.add(component);

        return nodes.toArray(new Node[1]);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitVectorComponent(this);
    }

    @Override
    public String toString() {
        return "Access Vector";
    }
}
