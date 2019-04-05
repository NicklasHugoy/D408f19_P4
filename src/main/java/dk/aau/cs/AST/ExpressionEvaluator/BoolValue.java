package dk.aau.cs.AST.ExpressionEvaluator;

import dk.aau.cs.Exceptions.OperationNotSupportedException;

public class BoolValue implements TempValue<Boolean>{

	private boolean value;

	public BoolValue(boolean value) {
		this.value = value;
	}

	@Override
	public TempValue add(TempValue<Boolean> other) {
		throw new OperationNotSupportedException("Adding booleans are not supported");
	}

	@Override
	public TempValue minus(TempValue<Boolean> other) {
		throw new OperationNotSupportedException("Subtracting booleans are not supported");
	}

	@Override
	public TempValue divide(TempValue<Boolean> other) {
		throw new OperationNotSupportedException("Dividing booleans are not supported");
	}

	@Override
	public TempValue times(TempValue<Boolean> other) {
		throw new OperationNotSupportedException("Multiplying booleans are not supported");
	}

	@Override
	public TempValue and(TempValue<Boolean> rightValue) {
		return new BoolValue(value && rightValue.getValue());
	}

	@Override
	public TempValue or(TempValue<Boolean> rightValue) {
		return new BoolValue(value || rightValue.getValue());
	}

	@Override
	public TempValue equal(TempValue<Boolean> rightValue) {
		return new BoolValue(value == rightValue.getValue());
	}

	@Override
	public TempValue inEqual(TempValue<Boolean> rightValue) {
		return new BoolValue(value != rightValue.getValue());
	}

	@Override
	public Boolean getValue() {
		return value;
	}
}
