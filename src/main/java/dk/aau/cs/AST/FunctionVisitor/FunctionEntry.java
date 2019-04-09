package dk.aau.cs.AST.FunctionVisitor;

import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.Nodes.Statement;

import java.util.ArrayList;
import java.util.List;

public class FunctionEntry {
	String id;
	GMMType returnType;

	ArrayList<GMMType> parameterTypes;

	List<Statement> statements;
	ArrayList<String> parameterNames;

	public FunctionEntry(String id, GMMType returnType, ArrayList<GMMType> parameterTypes, List<Statement> statements, ArrayList<String> parameterNames) {
		this.id = id;
		this.returnType = returnType;
		this.parameterTypes = parameterTypes;
		this.statements = statements;
		this.parameterNames = parameterNames;
	}

	public String getId() {
		return id;
	}

	public GMMType getReturnType() {
		return returnType;
	}

	public ArrayList<GMMType> getParameterTypes() {
		return parameterTypes;
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public ArrayList<String> getParameterNames() {
		return parameterNames;
	}
}
