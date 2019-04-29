package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.ExpressionEvaluator.IValue;
import dk.aau.cs.AST.GMMType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScopeTable{
    List<SymbolTableEntry> symbols;

    private boolean isolatedScope;

    public ScopeTable() {
        symbols = new ArrayList<>();
        isolatedScope = false;
    }

    public SymbolTableEntry find(String id){
        Optional<SymbolTableEntry> optionalSymbol = symbols.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst();
        return optionalSymbol.orElse(null);
    }

	public void add(String id, GMMType type, IValue value, Boolean writeProtected){
        SymbolTableEntry entry = find(id);
        if(entry == null){
            symbols.add(new SymbolTableEntry(id, type, value, writeProtected));
        } else {
            entry.setType(type);
            entry.setValue(value);
            entry.setWriteProtected(writeProtected);
        }
    }

    public boolean isIsolatedScope() {
        return isolatedScope;
    }

    public void isolate() {
        isolatedScope = true;
    }
}

