package dk.aau.cs.AST.TypeChecking;

public interface SymbolTable {
    <T> T get(String symbol);
    <T> void set(String symbol, T value);
    void enterScope();
    void leaveScope();
}
