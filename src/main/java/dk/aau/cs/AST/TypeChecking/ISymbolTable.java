package dk.aau.cs.AST.TypeChecking;

import com.ibm.icu.impl.Pair;
import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.Value;

public interface ISymbolTable {
    GMMType retrieveSymbolInScope(String symbol);

    GMMType retrieveSymbol(String symbol);
    TypeValuePair retrieveSymbolWithValue(String symbol);
    void enterSymbol(String symbol, GMMType type);
    void enterSymbol(String symbol, GMMType type, Value value);



    void openScope();
    void leaveScope();
}