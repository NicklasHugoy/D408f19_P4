package dk.aau.cs.ErrorReporting;

import dk.aau.cs.AST.Nodes.PositionedNode;

public class InvalidTypeInLoopRange extends PositionedErrorMessage {
	public InvalidTypeInLoopRange(String message, PositionedNode node) {
		super("Invalid type for range in loop: " + message, node, WarningLevel.Error);
	}
}
