package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.BaseNode;
import dk.aau.cs.AST.Statement;

import java.util.List;

public class FunctionDef implements BaseNode {

    public List<FormalParameter> parameters;
    public List<Statement> statements;

    public FunctionDef(List<FormalParameter> parameters, List<Statement> statements) {
        this.parameters = parameters;
        this.statements = statements;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitFunctionDef(this);
    }
}
