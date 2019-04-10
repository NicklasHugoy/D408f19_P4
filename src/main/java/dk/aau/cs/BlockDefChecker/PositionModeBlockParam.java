package dk.aau.cs.BlockDefChecker;

import dk.aau.cs.AST.Nodes.BlockDef;
import dk.aau.cs.AST.Nodes.ExplicitGCode;
import dk.aau.cs.ErrorReporting.InvalidBlockParameter;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.WarningLevel;

public class PositionModeBlockParam implements BlockParam {
	private ExplicitGCode gCode;

	public PositionModeBlockParam(String option, BlockDef blockDef) {
		gCode = generateGCode(option, blockDef);
	}

	private ExplicitGCode generateGCode(String option, BlockDef blockDef) {
		switch (option){
			case "absolute":
				return new ExplicitGCode(0, 0, "G90");
			case "relative":
				return new ExplicitGCode(0, 0, "G91");
			default:
				Logger.Log(new InvalidBlockParameter(
						"Block parameter 'positionMode' expected 'absolute' or 'relative' but got '" + option + "'",
						blockDef,
						WarningLevel.Error));
				return null;
		}
	}

	@Override
	public ExplicitGCode getGcode() {
		return gCode;
	}
}

