package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.*;

import java.util.List;

public class Variable implements Expression{

    public ID identifier;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitVariable(this);
    }
}

