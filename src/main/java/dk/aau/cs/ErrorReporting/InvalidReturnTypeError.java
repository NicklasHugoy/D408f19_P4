package dk.aau.cs.ErrorReporting;

import dk.aau.cs.AST.PositionedNode;

public class InvalidReturnTypeError extends PositionedErrorMessage {
    public InvalidReturnTypeError(String message, PositionedNode node) {
        super("Invalid return type error: "+message, node, WarningLevel.Error);
    }
}
