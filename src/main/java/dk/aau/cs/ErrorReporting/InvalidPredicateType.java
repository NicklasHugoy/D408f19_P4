package dk.aau.cs.ErrorReporting;

import dk.aau.cs.AST.PositionedNode;

public class InvalidPredicateType extends PositionedErrorMessage {
    public InvalidPredicateType(String message, PositionedNode node) {
        super("Predicate received invalid type error: " + message, node, WarningLevel.Error);
    }
}
