package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.IValue;

import java.util.ArrayList;
import java.util.List;

public class ScopeTable{
    List<SymbolTableEntry> symbols;

    public ScopeTable() {
        symbols = new ArrayList<>();
    }

    public TypeValuePair Find(String id){
        for(SymbolTableEntry symbol : symbols){
            if(symbol.getId().equals(id))
                return new TypeValuePair(symbol.getType(), symbol.getValue());
        }
        return null;
    }

    public void Add(String id, GMMType type){
        symbols.add(new SymbolTableEntry(id, type, null));
    }

	public void Add(String id, GMMType type, IValue value){
		symbols.add(new SymbolTableEntry(id, type, value));
	}
}

