package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.IValue;

public class SymbolTableEntry{
    private String Id;
    private GMMType type;
    private IValue value;

	public SymbolTableEntry(String id, GMMType type, IValue value) {
		Id = id;
		this.type = type;
		this.value = value;
	}

	public String getId() {
		return Id;
	}

	public GMMType getType() {
		return type;
	}

	public IValue getValue() {
		return value;
	}
}
