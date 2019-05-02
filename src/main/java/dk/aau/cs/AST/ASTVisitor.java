package dk.aau.cs.AST;

import dk.aau.cs.AST.Nodes.*;

public interface ASTVisitor<T> {
    default T visitProgram(Program program){ return null; }
    default T visitFunctionDef(FunctionDef functionDef){ return null; }
    default T visitFormalParameter(FormalParameter formalParameter){ return null; }
    default T visitTypeNode(TypeNode typeNode){ return null; }
    default T visitID(ID id){ return null; }
    default T visitMachineOption(MachineOption machineOption){ return null; }
    default T visitRelativeParameter(RelativeParameter relativeParameter){ return null; }
    default T visitDeclaration(Declaration declaration){ return null; }
    default T visitAssign(Assign assign){ return null; }
    default T visitFunctionCall(FunctionCall functionCall){ return null; }
    default T visitIfNode(IfNode ifNode){ return null; }
    default T visitLeftCircle(LeftCircle leftCircle){ return null; }
    default T visitAbsoluteParameter(AbsoluteParameter absoluteParameter){ return null; }
    default T visitEquality(Equality equality){ return null; }
    default T visitInEquality(InEquality inEquality){ return null; }
    default T visitAnd(And and){ return null; }
    default T visitOr(Or or){ return null; }
    default T visitDivide(Divide divide){ return null; }
    default T visitTimes(Times times){ return null; }
    default T visitPlus(Plus plus){ return null; }
    default T visitMinus(Minus minus){ return null; }
    default T visitVariable(Variable variable){ return null; }
    default T visitLiteralBool(LiteralBool literalBool){ return null; }
    default T visitLiteralNumber(LiteralNumber literalNumber){ return null; }
    default T visitRightCircle(RightCircle rightCircle){ return null; }
    default T visitMove(Move move){ return null; }
    default T visitBlockDef(BlockDef blockDef){ return null; }
    default T visitReturnNode(ReturnNode returnNode) {return  null; }
    default T visitGreaterThan(GreaterThan greaterThan) {return null; }
    default T visitLessThan(LessThan lessThan) {return null; }
    default T visitVectorComponentAssign(VectorComponentAssign vectorComponentAssign) {return null;}
    default T visitVectorComponent(VectorComponent vectorComponent){return null;}
    default T visitLiteralVector(LiteralVector literalVector){return null;}
    default T visitNegate(Negate negate) {return null;}
    default T visitExplicitGCode(ExplicitGCode explicitGCode) {return null;}
    default T visitSquareRoot(SquareRoot squareRoot) {return null;}
    default T visitVectorCommandParameter(VectorCommandParameter vectorCommandParameter) {return null;}
    default T visitJump(Jump jump) {return null;}
    default T visitLoop (Loop loop) {return null;}
}
