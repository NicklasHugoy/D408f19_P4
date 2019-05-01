package dk.aau.cs.BlockDefChecker;

import dk.aau.cs.AST.Nodes.BlockDef;
import dk.aau.cs.AST.Nodes.ExplicitGCode;
import dk.aau.cs.ErrorReporting.InvalidBlockParameter;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.WarningLevel;

public class ToolBlockParam extends BlockParam{

	ToolBlockParam(String option, BlockDef blockDef) {
		super(option, blockDef);
	}

	protected ExplicitGCode generateGCode(String option, BlockDef blockDef) {
		if(option.matches("\\d+")){
			return new ExplicitGCode(blockDef.lineNumber, blockDef.charNumber, "T" + option);
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
