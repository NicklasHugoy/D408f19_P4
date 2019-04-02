package dk.aau.cs.AST;

import dk.aau.cs.AST.Nodes.*;

public interface ASTVisitor<T> {
    default T visitProgram(Program n){ return null; }
    default T visitFunctionDef(FunctionDef n){ return null; }
    default T visitFormalParameter(FormalParameter n){ return null; }
    default T visitTypeNode(TypeNode n){ return null; }
    default T visitID(ID n){ return null; }
    default T visitMachineOption(MachineOption n){ return null; }
    default T visitRelativeParameter(RelativeParameter n){ return null; }
    default T visitDeclaration(Declaration n){ return null; }
    default T visitAssign(Assign n){ return null; }
    default T visitFunctionCall(FunctionCall n){ return null; }
    default T visitIfNode(IfNode n){ return null; }
    default T visitLeftCircle(LeftCircle n){ return null; }
    default T visitAbsoluteParameter(AbsoluteParameter n){ return null; }
    default T visitEquality(Equality n){ return null; }
    default T visitInEquality(InEquality n){ return null; }
    default T visitAnd(And n){ return null; }
    default T visitOr(Or n){ return null; }
    default T visitDivide(Divide n){ return null; }
    default T visitTimes(Times n){ return null; }
    default T visitPlus(Plus n){ return null; }
    default T visitMinus(Minus minus){ return null; }
    default T visitVariable(Variable variable){ return null; }
    default T visitLiteralBool(LiteralBool literalBool){ return null; }
    default T visitLiteralInt(LiteralInt literalInt){ return null; }
    default T visitRightCircle(RightCircle rightCircle){ return null; }
    default T visitMove(Move move){ return null; }
    default T visitBlockDef(BlockDef blockDef){ return null; }
}
