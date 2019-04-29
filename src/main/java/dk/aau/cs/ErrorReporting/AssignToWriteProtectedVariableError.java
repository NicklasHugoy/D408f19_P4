package dk.aau.cs.ErrorReporting;

import dk.aau.cs.AST.Nodes.PositionedNode;

public class AssignToWriteProtectedVariableError extends PositionedErrorMessage {
	public AssignToWriteProtectedVariableError(String message, PositionedNode node) {
		super("Can't assign to write protected variable: " + message, node, WarningLevel.Error);
	}
}
