package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.Value;

public class TypeValuePair{
	private GMMType type;
	private Value value;

	public TypeValuePair(GMMType type, Value value) {
		this.type = type;
		this.value = value;
	}

	public GMMType getType() {
		return type;
	}

	public void setType(GMMType type) {
		this.type = type;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}
}
