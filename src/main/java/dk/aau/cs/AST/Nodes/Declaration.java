package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.Statement;

import java.util.ArrayList;

public class Declaration implements Statement {
    public TypeNode type;
    public ID identifier;
    public Expression expression;

    public Declaration(TypeNode type, ID identifier, Expression expression) {
        this.type = type;
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public Node[] getChildren() {
        ArrayList<Node> nodes = new ArrayList<>();

        nodes.add(type);
        nodes.add(identifier);
        nodes.add(expression);

        return nodes.toArray(new Node[0]);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitDeclaration(this);
    }
}
