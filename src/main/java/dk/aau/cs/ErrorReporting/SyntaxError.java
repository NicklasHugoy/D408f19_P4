package dk.aau.cs.ErrorReporting;

public class SyntaxError extends ErrorMessage {
    public SyntaxError(String message, WarningLevel level) {
        super("Syntax "+level+": "+message, level);
    }
}
