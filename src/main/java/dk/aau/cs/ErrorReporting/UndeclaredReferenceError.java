package dk.aau.cs.ErrorReporting;

public class UndeclaredReferenceError extends  ErrorMessage {
    public UndeclaredReferenceError(String message) {
        super("Reference to an undeclared symbol error: " + message, WarningLevel.Error);
    }
}
