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

	private Stack<List<ExplicitGCode>> blockStack;

	public BlockDefChecker() {
		blockStack = new Stack<>();
	}

	public void enterBlock(BlockDef blockDef) {
		List<ExplicitGCode> gCodeArrayList = new ArrayList<>();

		for (MachineOption option : blockDef.options){
			switch (option.identifier.identifier){
				case "tool":
					BlockParam toolBlockParam = new ToolBlockParam(option.option, blockDef);
					gCodeArrayList.add(toolBlockParam.getGcode());
					break;
				case "unit":
					BlockParam unitBlockParam = new UnitBlockParam(option.option, blockDef);
					gCodeArrayList.add(unitBlockParam.getGcode());
					break;
				case "positionMode":
					BlockParam posBlockParam = new PositionModeBlockParam(option.option, blockDef);
					gCodeArrayList.add(posBlockParam.getGcode());
					break;
				default:
					Logger.Log(new InvalidBlockParameter(
							"block parameter '" + option.identifier.identifier + "' is not valid",
							blockDef,
							WarningLevel.Error));
			}
		}
		addGCode(blockDef, gCodeArrayList);
	}

	public List<ExplicitGCode> exitBlock(){
		if(blockStack.empty()){
			return new ArrayList<>();
		}else{
			blockStack.pop();
		}
		return blockStack.peek();
	}

	private void addGCode(BlockDef blockDef, List<ExplicitGCode> gCodeList){
		if (gCodeList.isEmpty())
			return;

		for(ExplicitGCode gCode : gCodeList){
			blockDef.statements.add(0, gCode);
		}
		blockStack.push(gCodeList);
	}
}
