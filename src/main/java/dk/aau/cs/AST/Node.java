package dk.aau.cs.AST;

public interface Node {
    <T> T accept(ASTVisitor<T> visitor);
}

