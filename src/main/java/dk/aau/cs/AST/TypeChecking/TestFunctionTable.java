package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.FunctionVisitor.FunctionEntry;

public interface TestFunctionTable {
    FunctionEntry retrieveFunction(String identifier);
    void enterFunction(FunctionEntry entry);
}
