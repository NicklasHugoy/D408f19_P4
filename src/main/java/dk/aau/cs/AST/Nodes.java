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

public class Declaration implements Statement{
    public TypeNode type;
    public ID identifier;
    public Expression expression;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitDeclaration(this);
    }
}

public class Assign implements Statement{
    public ID identifier;
    public Expression expression;


    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitAssign(this);
    }
}

public class FunctionCall implements Statement{
    public ID identifier;
    public List<Expression> parameters;


    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitFunctionCall(this);
    }
}

public class IfNode implements Statement{
    public Expression predicate;
    public List<Statement> statements;


    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitIfNode(this);
    }
}

public class LeftCircle implements Statement{
    public List<CommandParameter> parameters;


    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitLeftCircle(this);
    }
}

public class RightCircle implements Statement {
    public List<CommandParameter> parameters;


    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitRightCircle(this);
    }
}

public class Move implements Statement {
    public List<CommandParameter> parameters;


    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitMove(this);
    }
}

public class Equality implements Expression {

    public Expression left;
    public Expression right;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitEquality(this);
    }
}

public class InEquality implements Expression {

    public Expression left;
    public Expression right;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitInEquality(this);
    }
}

public class And implements Expression {

    public Expression left;
    public Expression right;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitAnd(this);
    }
}

public class Or implements Expression {

    public Expression left;
    public Expression right;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitOr(this);
    }
}

public class Divide implements Expression {

    public Expression left;
    public Expression right;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitDivide(this);
    }
}

public class Times implements Expression {

    public Expression left;
    public Expression right;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitTimes(this);
    }
}

public class Plus implements Expression {

    public Expression left;
    public Expression right;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitPlus(this);
    }
}

public class Minus implements Expression {

    public Expression left;
    public Expression right;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitMinus(this);
    }
}

public class Variable implements Expression{

    public ID identifier;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitVariable(this);
    }
}

public class LiteralBool implements Expression{

    public boolean boolValue;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitLeteralBool(this);
    }
}

public class LiteralInt implements Expression{

    public int value;

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitLiteralInt(this);
    }
}