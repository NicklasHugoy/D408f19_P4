package dk.aau.cs.AST.ExpressionEvaluator;

import dk.aau.cs.Exceptions.OperationNotSupportedException;

public class BoolValue implements IValue<Boolean> {

	private boolean value;

	public BoolValue(boolean value) {
		this.value = value;
	}

	@Override
	public IValue add(IValue<Boolean> other) {
		throw new OperationNotSupportedException("Adding booleans are not supported");
	}

	@Override
	public IValue minus(IValue<Boolean> other) {
		throw new OperationNotSupportedException("Subtracting booleans are not supported");
	}

	@Override
	public IValue divide(IValue<Boolean> other) {
		throw new OperationNotSupportedException("Dividing booleans are not supported");
	}

	@Override
	public IValue times(IValue<Boolean> other) {
		throw new OperationNotSupportedException("Multiplying booleans are not supported");
	}

	@Override
	public IValue and(IValue<Boolean> rightValue) {
		return new BoolValue(value && rightValue.getValue());
	}

	@Override
	public IValue or(IValue<Boolean> rightValue) {
		return new BoolValue(value || rightValue.getValue());
	}

	@Override
	public IValue equal(IValue<Boolean> rightValue) {
		return new BoolValue(value == rightValue.getValue());
	}

	@Override
	public IValue inEqual(IValue<Boolean> rightValue) {
		return new BoolValue(value != rightValue.getValue());
	}

	@Override
	public IValue greaterThan(IValue<Boolean> rightValue) {
		throw new OperationNotSupportedException("'greater than' are not supported for booleans");
	}

	@Override
	public IValue lessThan(IValue<Boolean> rightValue) {
		throw new OperationNotSupportedException("'less than' are not supported for booleans");
	}

	@Override
	public IValue negate() {
		return new BoolValue(!value);
	}

	@Override
	public Boolean getValue() {
		return value;
	}
}
