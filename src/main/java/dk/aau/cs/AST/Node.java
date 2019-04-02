package dk.aau.cs.AST;

import java.util.Collection;

public interface Node {
    Node[] getChildren();
    <T> T accept(ASTVisitor<T> visitor);
}

