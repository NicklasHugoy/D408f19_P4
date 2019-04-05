package dk.aau.cs.ErrorReporting;

import dk.aau.cs.AST.PositionedNode;

public class AssignmentTypeError extends PositionedErrorMessage {
    public AssignmentTypeError(String message, PositionedNode node) {
        super("Assignment type error: "+message, node, WarningLevel.Error);
    }
}
