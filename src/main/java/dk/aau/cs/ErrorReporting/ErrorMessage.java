package dk.aau.cs.ErrorReporting;

class ErrorMessage {

    private WarningLevel level;
    private String message;

    public ErrorMessage(String message, WarningLevel level) {
        this.message = message;
        this.level = level;
    }

    public WarningLevel getWarningLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}
