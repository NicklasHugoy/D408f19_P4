package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.FunctionVisitor.FunctionEntry;

import java.util.List;

public interface IFunctionTable {
    FunctionEntry retrieveFunction(String identifier);
    void enterFunction(FunctionEntry entry);
    List<FunctionEntry> retrieveFunctions();
}
