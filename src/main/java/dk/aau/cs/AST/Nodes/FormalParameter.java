package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Node;

public class FormalParameter implements Node {

    public TypeNode type;
    public ID identifier;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitFormalParameter(this);
    }
}
