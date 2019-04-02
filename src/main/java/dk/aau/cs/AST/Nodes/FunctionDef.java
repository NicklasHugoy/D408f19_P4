package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.BaseNode;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.Statement;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FunctionDef implements BaseNode {

    public TypeNode returnType;
    public ID idNode;
    public List<FormalParameter> parameters;
    public List<Statement> statements;

    public FunctionDef(List<FormalParameter> parameters, List<Statement> statements) {
        this.parameters = parameters;
        this.statements = statements;
    }

    @Override
    public Node[] getChildren() {
        ArrayList<Node> nodes = new ArrayList<>();

        nodes.addAll(parameters);
        nodes.addAll(statements);

        return nodes.toArray(new Node[0]);
    }

    @Override
    public String toString() {
        return "Function Definition";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitFunctionDef(this);
    }
}
