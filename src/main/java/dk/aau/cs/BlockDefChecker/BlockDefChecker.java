package dk.aau.cs.BlockDefChecker;

import dk.aau.cs.AST.ExpressionEvaluator.ExpressionEvaluatorVisitor;
import dk.aau.cs.AST.ExpressionEvaluator.IValue;
import dk.aau.cs.AST.ExpressionEvaluator.NumValue;
import dk.aau.cs.AST.Nodes.BlockDef;
import dk.aau.cs.AST.Nodes.ExplicitGCode;
import dk.aau.cs.AST.Nodes.MachineOption;
import dk.aau.cs.AST.TypeChecking.SymbolTable;
import dk.aau.cs.ErrorReporting.InvalidBlockParameter;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.WarningLevel;

import java.util.Stack;

public class BlockDefChecker {

	private SymbolTable symbolTable;

	private ExpressionEvaluatorVisitor expressionEvaluatorVisitor;
	private Stack<ExplicitGCode> blockStack;

	public BlockDefChecker(SymbolTable symbolTable) {
		this.symbolTable = symbolTable;
		expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(symbolTable);
		blockStack = new Stack<>();
	}

	public void enterBlock(BlockDef blockDef) {
		for (MachineOption option : blockDef.options){
			switch (option.identifier.identifier){
				case "tool":
					ExplicitGCode explicitGCode = toolChange(blockDef, option);
					addGCode(blockDef, explicitGCode);
					break;
				default:
					Logger.Log(new InvalidBlockParameter(
							"block parameter '" + option.identifier.identifier + "' is not valid",
							blockDef,
							WarningLevel.Error));
			}
		}
	}

	public void closeBlock(){
		blockStack.pop();
	}

	private void addGCode(BlockDef blockDef, ExplicitGCode gCode){
		if (null == gCode)
			return;
		blockDef.statements.add(0, gCode);
		if(!blockStack.empty()){
			blockDef.statements.add(blockStack.peek());
		}
		blockStack.push(gCode);
	}

	private ExplicitGCode toolChange(BlockDef blockDef, MachineOption option) {
		IValue toolNumberValue = option.expression.accept(expressionEvaluatorVisitor);
		if(toolNumberValue instanceof NumValue){
			int toolNumber = ((Double)toolNumberValue.getValue()).intValue();
			return new ExplicitGCode(0, 0, "T" + toolNumber);
		}
		Logger.Log(new InvalidBlockParameter(
				"Block parameter 'tool' expected value of type 'NumValue' but got '" + toolNumberValue.getClass().getSimpleName() + "'",
				blockDef,
				WarningLevel.Error));
		return null;
	}
}
