package dk.aau.cs.ErrorReporting;

import dk.aau.cs.AST.Nodes.PositionedNode;

public class MultipleCommandParameterError extends PositionedErrorMessage {
    public MultipleCommandParameterError(String message, PositionedNode node) {
        super("Multiple command parameters altering same parameter error: "+ message, node, WarningLevel.Error);
    }
}
