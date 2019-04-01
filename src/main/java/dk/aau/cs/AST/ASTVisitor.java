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
    T visitAbsoluteParameter(AbsouluteParameter n);
}
