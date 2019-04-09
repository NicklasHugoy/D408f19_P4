package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.ExpressionEvaluator.IValue;
import dk.aau.cs.AST.GMMType;

import java.util.ArrayList;
import java.util.List;

public class ScopeTable{
    List<SymbolTableEntry> symbols;

    private boolean isolatedScope;

    public ScopeTable() {
        symbols = new ArrayList<>();
        isolatedScope = false;
    }

    public ScopeTable(boolean isolatedScope) {
        symbols = new ArrayList<>();
        this.isolatedScope = isolatedScope;
    }

    public TypeValuePair Find(String id){
        for(SymbolTableEntry symbol : symbols){
            if(symbol.getId().equals(id))
                return new TypeValuePair(symbol.getType(), symbol.getValue());
        }
        return null;
    }

    public void Add(String id, GMMType type){
        for(SymbolTableEntry entry : symbols){
            if(entry.getId().equals(id)){
                entry.setType(type);
                return;
            }
        }

        symbols.add(new SymbolTableEntry(id, type, null));
    }

	public void Add(String id, GMMType type, IValue value){
        for(SymbolTableEntry entry : symbols){
            if(entry.getId().equals(id)){
                entry.setType(type);
                entry.setValue(value);
                return;
            }
        }

		symbols.add(new SymbolTableEntry(id, type, value));
	}

    public boolean isIsolatedScope() {
        return isolatedScope;
    }

    public void isolate() {
        isolatedScope = true;
    }
}

