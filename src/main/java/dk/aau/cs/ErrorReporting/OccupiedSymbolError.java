package dk.aau.cs.ErrorReporting;

import dk.aau.cs.AST.Nodes.PositionedNode;

public class OccupiedSymbolError extends PositionedErrorMessage {
    public OccupiedSymbolError(String message, PositionedNode node) {
        super("Already used symbol declared again error "+message, node, WarningLevel.Error);
    }
}
