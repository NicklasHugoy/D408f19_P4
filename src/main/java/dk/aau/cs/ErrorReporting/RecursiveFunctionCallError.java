package dk.aau.cs.ErrorReporting;

public class RecursiveFunctionCallError extends ErrorMessage {
    public RecursiveFunctionCallError(String recursionString) {
        super("Recursive function calls found " + recursionString, WarningLevel.Error);
    }
}
