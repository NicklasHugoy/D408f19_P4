package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.PositionedNode;

import java.util.ArrayList;

public class MachineOption extends PositionedNode implements Node {
    public ID identifier;
    public Expression expression;


    public MachineOption(ID identifier, Expression expression) {
        super(0,0);
        this.identifier = identifier;
        this.expression = expression;
    }

    public MachineOption(int lineNumber, int charNumber, ID identifier, Expression expression) {
        super(lineNumber, charNumber);
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
    public String toString() {
        return "MachineOption";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitMachineOption(this);
    }
}
