package dk.aau.cs.AST;

import java.lang.reflect.Type;
import java.util.List;

public class Program implements Node {

    public List<BaseNode> children;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitProgram(this);
    }
}

public class FunctionDef implements BaseNode{

    public List<FormalParameter> parameters;
    public List<Statement> statements;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitFunctionDef(this);
    }
}

public class FormalParameter implements Node{

    TypeNode type;
    ID identifier;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitFormalParameter(this);
    }
}

public class TypeNode implements Node{

    public GMMType type;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitTypeNode(this);
    }
}

public class ID implements Node{
    public String identifier;


    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitID(this);
    }
}

public class MachineOption implements Node{
    public ID identifier;
    public Expression expression;


    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitMachineOption(this);
    }
}

public class RelativeParameter implements CommandParameter{

    public ID identifier;

    public Expression expression;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitRelativeParameter(this);
    }
}

public class AbsouluteParameter implements CommandParameter{

    public ID identifier;

    public Expression expression;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitAbsoluteParameter(this);
    }
}




