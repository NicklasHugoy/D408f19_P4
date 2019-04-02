package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Expression;
import dk.aau.cs.AST.FunctionStatement;
import dk.aau.cs.AST.Node;

public class ReturnNode implements FunctionStatement {

    public Expression expression;

    public ReturnNode(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Node[] getChildren() {
        return new Node[]{expression};
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitReturnNode(this);
    }

    @Override
    public String toString() {
        return "Return";
    }
}
