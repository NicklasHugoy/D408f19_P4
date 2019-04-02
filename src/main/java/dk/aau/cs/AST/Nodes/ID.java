package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Node;

public class ID implements Node {
    public String identifier;


    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitID(this);
    }
}
