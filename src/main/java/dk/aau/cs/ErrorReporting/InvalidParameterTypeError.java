package dk.aau.cs.ErrorReporting;

import dk.aau.cs.AST.Nodes.PositionedNode;

public class InvalidParameterTypeError extends PositionedErrorMessage {
    public InvalidParameterTypeError(String message, PositionedNode node) {
        super("Mismatched argument type: "+message, node, WarningLevel.Error);
    }
}
