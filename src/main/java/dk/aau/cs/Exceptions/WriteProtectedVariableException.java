package dk.aau.cs.Exceptions;

public class WriteProtectedVariableException extends RuntimeException {
	public WriteProtectedVariableException(String message) {
		super(message);
	}
}
