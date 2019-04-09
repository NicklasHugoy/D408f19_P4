package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;

import java.util.ArrayList;

public class MachineOption extends PositionedNode implements Node {
    public ID identifier;
    public String option;

    public MachineOption(ID identifier, String option) {
        super(0, 0);
        this.identifier = identifier;
        this.option = option;
    }

    public MachineOption(int lineNumber, int charNumber, ID identifier, String option) {
        super(lineNumber, charNumber);
        this.identifier = identifier;
        this.option = option;
    }

    @Override
    public Node[] getChildren() {
        ArrayList<Node> nodes = new ArrayList<>();

        nodes.add(identifier);

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
