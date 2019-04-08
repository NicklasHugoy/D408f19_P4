package dk.aau.cs.Exceptions;

public class OperationNotSupportedException extends RuntimeException {
	public OperationNotSupportedException(String message) {
		super(message);
	}
}
