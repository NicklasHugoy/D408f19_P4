package dk.aau.cs.BlockDefChecker;

import dk.aau.cs.AST.Nodes.BlockDef;
import dk.aau.cs.AST.Nodes.ExplicitGCode;
import dk.aau.cs.AST.Nodes.MachineOption;
import dk.aau.cs.ErrorReporting.InvalidBlockParameter;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.WarningLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BlockDefChecker {

	private Stack<ExplicitGCode> blockStack;

	private Boolean insideFunction;
	private int blockDefFunctionCounter;

	public BlockDefChecker() {
		blockStack = new Stack<>();
		insideFunction = false;
		blockDefFunctionCounter = 0;
	}

	public void enterBlock(BlockDef blockDef) {
		if(insideFunction)
			blockDefFunctionCounter++;

		for (MachineOption option : blockDef.options){
			switch (option.identifier.identifier){
				case "tool":
					addGCode(blockDef, toolChange(blockDef, option.option));
					break;
				case "unit":
					addGCode(blockDef, unitChange(blockDef, option.option));
					break;
				default:
					Logger.Log(new InvalidBlockParameter(
							"block parameter '" + option.identifier.identifier + "' is not valid",
							blockDef,
							WarningLevel.Error));
			}
		}
	}

	public ExplicitGCode exitBlock(){
		if(insideFunction)
			blockDefFunctionCounter--;
		return blockStack.pop();
	}

	public void EnterFunction(){
		insideFunction = true;
	}

	public List<ExplicitGCode> exitFunction(){
		ArrayList<ExplicitGCode> gCodesList = new ArrayList<>();
		while (blockDefFunctionCounter > 0){
			gCodesList.add(blockStack.pop());
			blockDefFunctionCounter--;
		}
		return gCodesList;
	}

	private void addGCode(BlockDef blockDef, ExplicitGCode gCode){
		if (null == gCode)
			return;
		blockDef.statements.add(0, gCode);
		blockStack.push(gCode);
	}

	private ExplicitGCode unitChange(BlockDef blockDef, String option) {
		switch (option) {
			case "mm":
				return new ExplicitGCode(0, 0, "G21");
			case "inch":
				return new ExplicitGCode(0, 0, "G20");
			default:
				Logger.Log(new InvalidBlockParameter(
						"Block parameter 'unit' expected 'mm' or 'inch' but got '" + option + "'",
						blockDef,
						WarningLevel.Error));
				return null;
		}
	}

	private ExplicitGCode toolChange(BlockDef blockDef, String option) {
		if(option.matches("\\d+")){
			return new ExplicitGCode(0, 0, "T" + option);
		}
		else{
			Logger.Log(new InvalidBlockParameter(
					"Block parameter 'tool' expected a number but got '" + option + "'",
					blockDef,
					WarningLevel.Error));
			return null;
		}
	}
}
