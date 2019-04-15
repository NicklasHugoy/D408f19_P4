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
import java.util.stream.Collectors;

public class BlockDefChecker {

	private Stack<List<BlockParam>> blockStack;

	public BlockDefChecker() {
		blockStack = new Stack<>();
	}

	public void enterBlock(BlockDef blockDef) {
		List<BlockParam> gCodeArrayList = new ArrayList<>();

		for (MachineOption option : blockDef.options){
			switch (option.identifier.identifier){
				case "tool":
					gCodeArrayList.add(new ToolBlockParam(option.option, blockDef));
					break;
				case "unit":
					gCodeArrayList.add(new UnitBlockParam(option.option, blockDef));
					break;
				case "positionMode":
					gCodeArrayList.add(new PositionModeBlockParam(option.option, blockDef));
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
		if(!blockStack.empty()){
			blockStack.pop();
		}

		return getTopOfStackAsExplicitGCode();
	}

	private List<ExplicitGCode> getTopOfStackAsExplicitGCode() {
		List<ExplicitGCode> gCodesToReturn = new ArrayList<>();
		if(!blockStack.empty()){
			gCodesToReturn = blockStack.peek().stream().map(BlockParam::getGcode).collect(Collectors.toList());
		}
		return gCodesToReturn;
	}


	private void addGCode(BlockDef blockDef, List<BlockParam> gCodeList){
		if (gCodeList.isEmpty())
			return;

		addGCodeToStartOfBlock(blockDef, gCodeList);

		if(!blockStack.empty()){
			blockStack.push(copyUnoverridenPreviousParams(gCodeList, blockStack.peek()));
		}else{
			blockStack.push(gCodeList);
		}
	}

	private void addGCodeToStartOfBlock(BlockDef blockDef, List<BlockParam> gCodeList) {
		for(BlockParam blockParam : gCodeList){
			blockDef.statements.add(0, blockParam.getGcode());
		}
	}

	private List<BlockParam> copyUnoverridenPreviousParams(List<BlockParam> newBlockParams, List<BlockParam> previousBlockParams) {
		List<BlockParam> blockParamsToReturn = new ArrayList<>(List.copyOf(newBlockParams));

		for(BlockParam previousBlocParam : previousBlockParams){
			if(newBlockParams.stream().noneMatch(
					newBlockParam -> newBlockParam.getClass().equals(previousBlocParam.getClass()))){
				blockParamsToReturn.add(previousBlocParam);
			}
		}

		return blockParamsToReturn;
	}
}
