package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FunctionDef extends PositionedNode implements BaseNode {

    public TypeNode returnType;
    public ID idNode;
    public List<FormalParameter> parameters;
    public List<Statement> statements;

    public FunctionDef(TypeNode returnType, ID idNode, List<FormalParameter> parameters, List<Statement> statements) {
        super(0,0);
        this.returnType = returnType;
        this.idNode = idNode;
        this.parameters = parameters;
        this.statements = statements;
    }

    public FunctionDef(int lineNumber, int charNumber, TypeNode returnType, ID idNode, List<FormalParameter> parameters, List<Statement> statements) {
        super(lineNumber, charNumber);
        this.returnType = returnType;
        this.idNode = idNode;
        this.parameters = parameters;
        this.statements = statements;
    }

    @Override
    public Node[] getChildren() {
        ArrayList<Node> nodes = new ArrayList<>();

        nodes.add(returnType);
        nodes.add(idNode);
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
