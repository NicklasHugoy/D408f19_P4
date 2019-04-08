package dk.aau.cs.ErrorReporting;

import dk.aau.cs.AST.Nodes.PositionedNode;

public class MismatchedExpressionTypeError extends PositionedErrorMessage {

    public MismatchedExpressionTypeError(String message, PositionedNode node) {
        super("Mismatched expression type error: " + message, node, WarningLevel.Error);
    }
}
