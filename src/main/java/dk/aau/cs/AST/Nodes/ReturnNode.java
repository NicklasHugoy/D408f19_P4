package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.*;

public class ReturnNode extends PositionedNode implements FunctionStatement {

    public Expression expression;

    public ReturnNode(Expression expression) {
        super(0,0);
        this.expression = expression;
    }

    public ReturnNode(int lineNumber, int charNumber, Expression expression) {
        super(lineNumber, charNumber);
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
