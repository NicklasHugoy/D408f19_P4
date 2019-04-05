package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;

public interface Node {
    Node[] getChildren();
    <T> T accept(ASTVisitor<T> visitor);
}

