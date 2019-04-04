package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.GMMType;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.WarningLevel;

import java.util.LinkedList;

public class SymbolTable implements ISymbolTable {
    private LinkedList<ScopeTable> scopes;

    public SymbolTable() {
        scopes = new LinkedList<>();
    }

    @Override
    public GMMType retrieveSymbol(String symbol) {
        for(int i = scopes.size() - 1; i >= 0; i--){
            GMMType type = scopes.get(i).Find(symbol);
            if(type != null)
                return type;
        }

        Logger.Log("Variable '" + symbol + "' has not been declared", WarningLevel.Error);
        return GMMType.Void;
    }

    @Override
    public void enterSymbol(String symbol, GMMType type) {
        scopes.getLast().Add(symbol, type);
    }

    @Override
    public void openScope() {
        scopes.add(new ScopeTable());
    }

    @Override
    public void leaveScope() {
        scopes.removeLast();
    }
}