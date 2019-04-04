package dk.aau.cs.AST.FunctionVisitor;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.BaseNode;
import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.Nodes.FunctionDef;
import dk.aau.cs.AST.Nodes.Program;
import dk.aau.cs.AST.TypeChecking.IFunctionTable;

import java.util.ArrayList;
import java.util.List;

public class FunctionVisitor implements ASTVisitor<List<FunctionEntry>> {

	private ArrayList<FunctionEntry> functionEntries = new ArrayList<>();

	private IFunctionTable functionTable;

	public FunctionVisitor(IFunctionTable functionTable) {
		this.functionTable = functionTable;
	}

	@Override
	public ArrayList<FunctionEntry> visitProgram(Program program) {

		for (BaseNode baseNode : program.children) {
			if (baseNode instanceof FunctionDef) {
				baseNode.accept(this);
			}
		}
		return functionEntries;
	}

	@Override
	public List<FunctionEntry> visitFunctionDef(FunctionDef functionDef) {
		ArrayList<GMMType> parameters = new ArrayList<>();
		functionDef.parameters.forEach(parameter -> parameters.add(parameter.type.type));

		FunctionEntry function = new FunctionEntry(functionDef.idNode.identifier, functionDef.returnType.type, parameters);

		functionTable.enterFunction(function);
		functionEntries.add(function);
		return null;
	}
}
