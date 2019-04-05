package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.BaseNode;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.PositionedNode;

import java.util.List;

public class Program extends PositionedNode implements Node {

    public List<BaseNode> children;

    public Program(List<BaseNode> children) {
        super(0,0);
        this.children = children;
    }

    public Program(int lineNumber, int charNumber, List<BaseNode> children) {
        super(lineNumber, charNumber);
        this.children = children;
    }

    @Override
    public Node[] getChildren() {
        return children.toArray(new Node[0]);
    }

    @Override
    public String toString() {
        return "Program";
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitProgram(this);
    }
}
