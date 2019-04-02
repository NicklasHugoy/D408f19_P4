package dk.aau.cs.AST.Nodes;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.BaseNode;
import dk.aau.cs.AST.Node;

import java.util.List;

public class Program implements Node {

    public List<BaseNode> children;

    public Program(List<BaseNode> children) {
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
