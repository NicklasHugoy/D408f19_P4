package dk.aau.cs.AST.FunctionVisitor;

import dk.aau.cs.AST.GMMType;

import java.util.ArrayList;

public class FunctionEntry {
	String id;
	GMMType returnType;
	ArrayList<GMMType> parameterTypes;

	public FunctionEntry(String id, GMMType returnType, ArrayList<GMMType> parameterTypes) {
		this.id = id;
		this.returnType = returnType;
		this.parameterTypes = parameterTypes;
	}
}
