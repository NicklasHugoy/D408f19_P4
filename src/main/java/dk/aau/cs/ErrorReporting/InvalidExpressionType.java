package dk.aau.cs.ErrorReporting;

import dk.aau.cs.AST.PositionedNode;

public class InvalidExpressionType extends  PositionedErrorMessage {
    public InvalidExpressionType(String message, PositionedNode node) {
        super("Invalid expression type error: " + message, node, WarningLevel.Error);
    }
}
