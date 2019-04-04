package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.FunctionVisitor.FunctionEntry;

public interface IFunctionTable {
    FunctionEntry retrieveFunction(String identifier);
    void enterFunction(FunctionEntry entry);
}
