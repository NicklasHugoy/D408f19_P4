package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.*;

import java.util.ArrayList;

public class Declaration extends PositionedNode implements Statement {
    public TypeNode type;
    public ID identifier;
    public Expression expression;

    public Declaration(TypeNode type, ID identifier, Expression expression) {
        super(0,0);
        this.type = type;
        this.identifier = identifier;
        this.expression = expression;
    }

    public Declaration(int lineNumber, int charNumber, TypeNode type, ID identifier, Expression expression) {
        super(lineNumber, charNumber);
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
    public String toString() {
        return "Declaration";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitDeclaration(this);
    }
}
