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
					addGCode(blockDef, toolChange(blockDef, option));
					break;
				case "unit":
					addGCode(blockDef, unitChange(blockDef, option));
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

	private ExplicitGCode unitChange(BlockDef blockDef, MachineOption option) {
		return null;
	}

	private ExplicitGCode toolChange(BlockDef blockDef, MachineOption option) {
		String optionString = option.option.replaceAll("\\s+","");
		if(optionString.matches("\\d+")){
			return new ExplicitGCode(0, 0, "T" + optionString);
		}
		else{
			Logger.Log(new InvalidBlockParameter(
					"Block parameter 'tool' expected a number but got '" + optionString + "'",
					blockDef,
					WarningLevel.Error));
			return null;
		}
	}
}
