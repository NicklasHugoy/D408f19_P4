package dk.aau.cs.AST.FunctionVisitor;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.Nodes.BaseNode;
import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.Nodes.FunctionDef;
import dk.aau.cs.AST.Nodes.Program;
import dk.aau.cs.AST.TypeChecking.IFunctionTable;

import java.util.ArrayList;
import java.util.List;

public class FunctionVisitor implements ASTVisitor {

	private IFunctionTable functionTable;

	public FunctionVisitor(IFunctionTable functionTable) {
		this.functionTable = functionTable;
	}

	@Override
	public Object visitProgram(Program program) {

		for (BaseNode baseNode : program.children) {
			if (baseNode instanceof FunctionDef) {
				baseNode.accept(this);
			}
		}
		return null;
	}

	@Override
	public Object visitFunctionDef(FunctionDef functionDef) {
		ArrayList<GMMType> parameters = new ArrayList<>();
		ArrayList<String> names = new ArrayList<>();
		functionDef.parameters.forEach(parameter -> {parameters.add(parameter.type.type); names.add(parameter.identifier.identifier);});

		FunctionEntry function = new FunctionEntry(functionDef.idNode.identifier, functionDef.returnType.type, parameters, functionDef.statements, names);

		functionTable.enterFunction(function);
		return null;
	}
}
