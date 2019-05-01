package dk.aau.cs.BlockDefChecker;

import dk.aau.cs.AST.Nodes.BlockDef;
import dk.aau.cs.AST.Nodes.ExplicitGCode;
import dk.aau.cs.AST.Nodes.MachineOption;
import dk.aau.cs.ErrorReporting.InvalidBlockParameter;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.WarningLevel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class BlockDefChecker {

	private Stack<List<BlockParam>> blockStack;

	public BlockDefChecker() {
		blockStack = new Stack<>();
	}

	public void enterFirstBlock(BlockDef blockDef){
		List<String> optionIdentifiers = blockDef.options.stream()
				.map(machineOption -> machineOption.identifier.identifier).sorted(String::compareTo)
				.collect(Collectors.toList());

		List<String> expectedOptions = new ArrayList<>(List.of("tool", "unit", "positionMode", "speed", "spinrate"));
		expectedOptions.sort(String::compareTo);

		if(!expectedOptions.equals(optionIdentifiers)){
			Logger.Log(new InvalidBlockParameter(
					"Missing parameters in first block",
					blockDef,
					WarningLevel.Error));
		}
	}

	public List<ExplicitGCode> enterBlock(BlockDef blockDef) {
		List<BlockParam> gCodeToReturn = identifyParameters(blockDef);
		List<BlockParam> gCodeToStack;

		if(!blockStack.empty()){
			gCodeToStack = new ArrayList<>(getUnoverridenPreviousParams(gCodeToReturn, blockStack.peek()));
		} else {
			gCodeToStack = List.copyOf(gCodeToReturn);
		}
		blockStack.push(gCodeToStack);

		if(!blockStack.empty()) {
			gCodeToReturn = getDifferenceBetweenLists(gCodeToReturn, blockStack.peek());
		}

		return blockParamsToExplicitGCode(gCodeToReturn);
	}

	private List<BlockParam> getDifferenceBetweenLists(List<BlockParam> list1,
														List<BlockParam> list2) {
		List<BlockParam> blockParamsToReturn = new ArrayList<>();

		for(BlockParam previousBlockParam : list2 ){
			for(BlockParam currentBlockParam : list1){
				if(previousBlockParam.getClass().equals(currentBlockParam.getClass()) && !previousBlockParam.equals(currentBlockParam)){
					blockParamsToReturn.add(currentBlockParam);
					break;
				}
			}
		}
		return blockParamsToReturn;
	}

	private List<BlockParam> identifyParameters(BlockDef blockDef) {
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
				case "speed":
					gCodeArrayList.add(new speedBlockParam(option.option, blockDef));
					break;
				case "spinrate":
					gCodeArrayList.add(new spinrateBlockParam(option.option, blockDef));
					break;
				default:
					Logger.Log(new InvalidBlockParameter(
							"block parameter '" + option.identifier.identifier + "' is not valid",
							blockDef,
							WarningLevel.Error));
			}
		}
		return gCodeArrayList;
	}

	private List<BlockParam> getUnoverridenPreviousParams(List<BlockParam> newBlockParams,
														List<BlockParam> previousBlockParams) {
		List<BlockParam> blockParamsToReturn = new ArrayList<>(List.copyOf(newBlockParams));

		for(BlockParam previousBlocParam : previousBlockParams){
			if(newBlockParams.stream().noneMatch(
					newBlockParam -> newBlockParam.getClass().equals(previousBlocParam.getClass()))){
				blockParamsToReturn.add(previousBlocParam);
			}
		}

		return blockParamsToReturn;
	}

	public List<ExplicitGCode> exitBlock(){
		List<BlockParam> blockParams = new ArrayList<>();
		if(!blockStack.empty()){
			blockParams = blockStack.pop();
		}

		if(!blockStack.empty()) {
			return blockParamsToExplicitGCode(getDifferenceBetweenLists(blockStack.peek(), blockParams));
		} else {
			return new ArrayList<>();
		}
	}

	private List<ExplicitGCode> blockParamsToExplicitGCode(List<BlockParam> blockParams){
		return blockParams.stream().map(BlockParam::getGcode).collect(Collectors.toList());
	}
}
