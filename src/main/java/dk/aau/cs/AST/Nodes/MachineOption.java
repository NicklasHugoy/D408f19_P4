package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Node;

public class MachineOption implements Node {
    public ID identifier;
    public Expression expression;


    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitMachineOption(this);
    }
}
