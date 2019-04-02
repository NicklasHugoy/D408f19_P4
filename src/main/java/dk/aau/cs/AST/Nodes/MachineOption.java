package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Node;

import java.util.ArrayList;

public class MachineOption implements Node {
    public ID identifier;
    public Expression expression;


    public MachineOption(ID identifier, Expression expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public Node[] getChildren() {
        ArrayList<Node> nodes = new ArrayList<>();

        nodes.add(identifier);
        nodes.add(expression);

        return nodes.toArray(new Node[0]);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitMachineOption(this);
    }
}
