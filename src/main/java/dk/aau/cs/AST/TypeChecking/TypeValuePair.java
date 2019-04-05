package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.IValue;

public class TypeValuePair{
	private GMMType type;
	private IValue value;

	public TypeValuePair(GMMType type, IValue value) {
		this.type = type;
		this.value = value;
	}

	public GMMType getType() {
		return type;
	}

	public void setType(GMMType type) {
		this.type = type;
	}

	public IValue getValue() {
		return value;
	}

	public void setValue(IValue value) {
		this.value = value;
	}
}
