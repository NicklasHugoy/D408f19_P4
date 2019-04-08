package dk.aau.cs.AST.ExpressionEvaluator;

import dk.aau.cs.Exceptions.OperationNotSupportedException;

public class NumValue implements IValue<Float> {
	private float value;

	public NumValue(float value) {
		this.value = value;
	}

	@Override
	public NumValue add(IValue<Float> other) {
		return new NumValue(value + other.getValue());
	}

	@Override
	public NumValue minus(IValue<Float> other) {
		return new NumValue(value - other.getValue());
	}

	@Override
	public NumValue divide(IValue<Float> other) {
		return new NumValue(value / other.getValue());
	}

	@Override
	public NumValue times(IValue<Float> other) {
		return new NumValue(value * other.getValue());
	}

	@Override
	public IValue and(IValue<Float> rightValue) {
		throw new OperationNotSupportedException("'And' operation is not supported on num");
	}

	@Override
	public IValue or(IValue<Float> rightValue) {
		throw new OperationNotSupportedException("'Or' operation is not supported on num");
	}

	@Override
	public IValue equal(IValue<Float> rightValue) {
		return new BoolValue(value == rightValue.getValue());
	}

	@Override
	public IValue inEqual(IValue<Float> rightValue) {
		return new BoolValue(value != rightValue.getValue());
	}

	@Override
	public IValue greaterThan(IValue<Float> rightValue) {
		return new BoolValue(value > rightValue.getValue());
	}

	@Override
	public IValue lessThan(IValue<Float> rightValue) {
		return new BoolValue(value < rightValue.getValue());
	}

	@Override
	public IValue negate() {
		return new NumValue(-value);
	}

	@Override
	public Float getValue() {
		return value;
	}
}
