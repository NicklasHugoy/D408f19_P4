package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.ExpressionEvaluator.IValue;
import dk.aau.cs.AST.GMMType;

public class SymbolTableEntry{
    private String Id;
    private GMMType type;
    private IValue value;
    private boolean writeProtected;

	public SymbolTableEntry(String id, GMMType type, IValue value) {
		Id = id;
		this.type = type;
		this.value = value;
		writeProtected = false;
	}

	public SymbolTableEntry(String id, GMMType type, IValue value, boolean writeProtected) {
		Id = id;
		this.type = type;
		this.value = value;
		this.writeProtected = writeProtected;
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

	public void setType(GMMType type) {
		this.type = type;
	}

	public void setValue(IValue value) {
		this.value = value;
	}

	public boolean isWriteProtected() {
		return writeProtected;
	}

	public void setWriteProtected(boolean writeProtected) {
		this.writeProtected = writeProtected;
	}
}
