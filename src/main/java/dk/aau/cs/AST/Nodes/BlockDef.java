package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.*;

import java.util.ArrayList;
import java.util.List;

public class BlockDef extends PositionedNode implements Statement, BaseNode {
    public List<MachineOption> options;
    public List<Statement> statements;

    public BlockDef(List<MachineOption> options, List<Statement> statements) {
        super(0,0);
        this.options = options;
        this.statements = statements;
    }

    public BlockDef(int lineNumber, int charNumber, List<MachineOption> options, List<Statement> statements) {
        super(lineNumber, charNumber);
        this.options = options;
        this.statements = statements;
    }

    @Override
    public Node[] getChildren() {
        ArrayList<Node> nodes = new ArrayList<>();

        nodes.addAll(options);
        nodes.addAll(statements);

        return nodes.toArray(new Node[0]);
    }

    @Override
    public String toString() {
        return "Block definition";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitBlockDef(this);
    }
}
