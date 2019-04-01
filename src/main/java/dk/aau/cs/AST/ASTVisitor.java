package dk.aau.cs.AST;

import dk.aau.cs.GMMParser;

public interface ASTVisitor<T> {
    T visitProgram(Program n);
    T visitFunctionDef(FunctionDef n);
    T visitFormalParameter(FormalParameter n);
    T visitTypeNode(TypeNode n);
    T visitID(ID n);
    T visitMachineOption(MachineOption n);
    T visitRelativeParameter(RelativeParameter n);
    T visitDeclaration(Declaration n);
    T visitAssign(Assign n);
    T visitFunctionCall(FunctionCall n);
    T visitIfNode(IfNode n);
    T visitLeftCircle(LeftCircle n);
    T visitAbsoluteParameter(AbsouluteParameter n);
    T visitEquality(Equality n);
	T visitInEquality(InEquality n);
	T visitAnd(And n);
	T visitOr(Or n);
	T visitDivide(Divide n);
	T visitTimes(Times n);
	T visitPlus(Plus n);
	T visitMinus(Minus minus);
	T visitVariable(Variable variable);
	T visitLiteralBool(LiteralBool literalBool);
	T visitLiteralInt(LiteralInt literalInt);
    T visitRightCircle(RightCircle rightCircle);
    T visitMove(Move move);
    T visitBlockDef(BlockDef blockDef);
}
