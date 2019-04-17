package dk.aau.cs.BlockDefChecker;

import dk.aau.cs.AST.Nodes.BlockDef;
import dk.aau.cs.AST.Nodes.ExplicitGCode;
import dk.aau.cs.ErrorReporting.InvalidBlockParameter;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.WarningLevel;

public class spinrateBlockParam implements BlockParam {
	private ExplicitGCode gCode;

	public spinrateBlockParam(String option, BlockDef blockDef) {
		gCode = generateGCode(option, blockDef);
	}

	private ExplicitGCode generateGCode(String option, BlockDef blockDef) {
		if(option.matches("\\d+")){
			return new ExplicitGCode(blockDef.lineNumber, blockDef.charNumber, "S" + option);
		}else {
			Logger.Log(new InvalidBlockParameter(
					"Block parameter 'spinrate' expected a number but got '" + option + "'",
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
