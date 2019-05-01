package dk.aau.cs.BlockDefChecker;

import dk.aau.cs.AST.Nodes.BlockDef;
import dk.aau.cs.AST.Nodes.ExplicitGCode;
import dk.aau.cs.ErrorReporting.InvalidBlockParameter;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.WarningLevel;

public class UnitBlockParam extends BlockParam{

	UnitBlockParam(String option, BlockDef blockDef) {
		super(option, blockDef);
	}

	protected ExplicitGCode generateGCode(String option, BlockDef blockDef) {
		switch (option) {
			case "mm":
				return new ExplicitGCode(blockDef.lineNumber, blockDef.charNumber, "G21");
			case "inch":
				return new ExplicitGCode(blockDef.lineNumber, blockDef.charNumber, "G20");
			default:
				Logger.Log(new InvalidBlockParameter(
						"Block parameter 'unit' expected 'mm' or 'inch' but got '" + option + "'",
						blockDef,
						WarningLevel.Error));
				return null;
		}
	}
}
