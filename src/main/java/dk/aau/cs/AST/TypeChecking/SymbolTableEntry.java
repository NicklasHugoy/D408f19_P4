package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.Value;

public class SymbolTableEntry{
    private String Id;
    private GMMType type;
    private Value value;

	public SymbolTableEntry(String id, GMMType type, Value value) {
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

	public Value getValue() {
		return value;
	}
}
