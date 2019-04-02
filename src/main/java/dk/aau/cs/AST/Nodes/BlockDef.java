package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.BaseNode;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.Statement;

import java.util.ArrayList;
import java.util.List;

public class BlockDef implements Statement, BaseNode {
    public List<MachineOption> options;
    public List<Statement> statements;

    public BlockDef(List<MachineOption> options, List<Statement> statements) {
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
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitBlockDef(this);
    }
}
