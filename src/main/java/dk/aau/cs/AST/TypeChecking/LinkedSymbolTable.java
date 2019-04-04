package dk.aau.cs.AST.TypeChecking;

import com.ibm.icu.impl.Pair;
import dk.aau.cs.AST.GMMType;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.WarningLevel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedSymbolTable implements TestSymbolTable{
    private LinkedList<ScopeTable> scopes;

    public LinkedSymbolTable() {
        scopes = new LinkedList<>();
    }

    @Override
    public GMMType retrieveSymbol(String symbol) {
        for(int i = scopes.size() - 1; i >= 0; i--){
            GMMType type = scopes.get(i).Find(symbol);
            if(type != null)
                return type;
        }

        Logger.Log("Symbol'" + symbol + "' couldnt be found", WarningLevel.Error);
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

class ScopeTable{
    List<Pair<String, GMMType>> symbols;

    public ScopeTable() {
        symbols = new ArrayList<>();
    }

    public GMMType Find(String id){
        for(Pair<String, GMMType> symbol : symbols){
            if(symbol.first.equals(id))
                return symbol.second;
        }
        return null;
    }

    public void Add(String id, GMMType type){
        symbols.add(Pair.of(id, type));
    }
}
