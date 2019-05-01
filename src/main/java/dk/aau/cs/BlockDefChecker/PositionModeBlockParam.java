package dk.aau.cs.BlockDefChecker;

import dk.aau.cs.AST.Nodes.BlockDef;
import dk.aau.cs.AST.Nodes.ExplicitGCode;
import dk.aau.cs.ErrorReporting.InvalidBlockParameter;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.WarningLevel;

public class PositionModeBlockParam extends BlockParam {

	PositionModeBlockParam(String option, BlockDef blockDef) {
		super(option, blockDef);
	}

	protected ExplicitGCode generateGCode(String option, BlockDef blockDef) {
		switch (option){
			case "absolute":
				return new ExplicitGCode(blockDef.lineNumber, blockDef.charNumber, "G90");
			case "relative":
				return new ExplicitGCode(blockDef.lineNumber, blockDef.charNumber, "G91");
			default:
				Logger.Log(new InvalidBlockParameter(
						"Block parameter 'positionMode' expected 'absolute' or 'relative' but got '" + option + "'",
						blockDef,
						WarningLevel.Error));
				return null;
		}
	}
}

