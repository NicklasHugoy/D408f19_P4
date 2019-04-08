package dk.aau.cs.AST.ExpressionEvaluator;

import dk.aau.cs.Exceptions.OperationNotSupportedException;

public class NumValue implements IValue<Double> {
	private double value;

	public NumValue(double value) {
		this.value = value;
	}

	@Override
	public NumValue add(IValue<Double> other) {
		return new NumValue(value + other.getValue());
	}

	@Override
	public NumValue minus(IValue<Double> other) {
		return new NumValue(value - other.getValue());
	}

	@Override
	public NumValue divide(IValue<Double> other) {
		return new NumValue(value / other.getValue());
	}

	@Override
	public NumValue times(IValue<Double> other) {
		return new NumValue(value * other.getValue());
	}

	@Override
	public IValue and(IValue<Double> rightValue) {
		throw new OperationNotSupportedException("'And' operation is not supported on num");
	}

	@Override
	public IValue or(IValue<Double> rightValue) {
		throw new OperationNotSupportedException("'Or' operation is not supported on num");
	}

	@Override
	public IValue equal(IValue<Double> rightValue) {
		return new BoolValue(value == rightValue.getValue());
	}

	@Override
	public IValue inEqual(IValue<Double> rightValue) {
		return new BoolValue(value != rightValue.getValue());
	}

	@Override
	public IValue greaterThan(IValue<Double> rightValue) {
		return new BoolValue(value > rightValue.getValue());
	}

	@Override
	public IValue lessThan(IValue<Double> rightValue) {
		return new BoolValue(value < rightValue.getValue());
	}

	@Override
	public IValue negate() {
		return new NumValue(-value);
	}

	@Override
	public Double getValue() {
		return value;
	}
}
