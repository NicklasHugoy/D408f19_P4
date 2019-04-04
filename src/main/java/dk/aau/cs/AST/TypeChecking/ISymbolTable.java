package dk.aau.cs.AST.TypeChecking;

public interface ISymbolTable {
    <T> T retrieveSymbol(String symbol);
    <T> void enterSymbol(String symbol, T value);
    void openScope();
    void leaveScope();
}