package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.ExpressionEvaluator.IValue;
import dk.aau.cs.AST.GMMType;

public interface ISymbolTable {
    GMMType retrieveSymbolInScope(String symbol);

    GMMType retrieveSymbol(String symbol);
    TypeValuePair retrieveSymbolWithValue(String symbol);
    void enterSymbol(String symbol, GMMType type);
    void enterSymbol(String symbol, GMMType type, IValue value);
    void assignValue(String symbol, IValue value);



    void openScope();
    void isolateScope();
    void leaveScope();

    void assignWriteProtectedValue(String symbol, IValue value);
    void enterWriteProtectedSymbol(String symbol, GMMType type);
}