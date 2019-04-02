package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Statement;

public class WhileLoop implements Statement {
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitWhileLoop(this);
    }
}
