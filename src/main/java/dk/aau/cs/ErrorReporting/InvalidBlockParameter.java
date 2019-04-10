package dk.aau.cs.ErrorReporting;

import dk.aau.cs.AST.Nodes.PositionedNode;

public class InvalidBlockParameter extends PositionedErrorMessage {
	public InvalidBlockParameter(String message, PositionedNode node, WarningLevel level) {
		super("Invalid block parameter error: " + message, node, level);
	}
}
