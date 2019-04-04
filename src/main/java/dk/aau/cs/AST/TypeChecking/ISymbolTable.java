package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.GMMType;

public interface ISymbolTable {
    GMMType retrieveSymbolInScope(String symbol);

    GMMType retrieveSymbol(String symbol);
    void enterSymbol(String symbol, GMMType type);



    void openScope();
    void leaveScope();
}