package dk.aau.cs.AST.ExpressionEvaluator;

import dk.aau.cs.Exceptions.OperationNotSupportedException;

public class NumValue implements TempValue<Float>{
	private float value;

	public NumValue(float value) {
		this.value = value;
	}

	@Override
	public NumValue add(TempValue<Float> other) {
		return new NumValue(value + other.getValue());
	}

	@Override
	public NumValue minus(TempValue<Float> other) {
		return new NumValue(value - other.getValue());
	}

	@Override
	public NumValue divide(TempValue<Float> other) {
		return new NumValue(value / other.getValue());
	}

	@Override
	public NumValue times(TempValue<Float> other) {
		return new NumValue(value * other.getValue());
	}

	@Override
	public TempValue and(TempValue<Float> rightValue) {
		throw new OperationNotSupportedException("'And' operation is not supported on num");
	}

	@Override
	public TempValue or(TempValue<Float> rightValue) {
		throw new OperationNotSupportedException("'Or' operation is not supported on num");
	}

	@Override
	public TempValue equal(TempValue<Float> rightValue) {
		return new BoolValue(value == rightValue.getValue());
	}

	@Override
	public TempValue inEqual(TempValue<Float> rightValue) {
		return new BoolValue(value != rightValue.getValue());
	}

	@Override
	public Float getValue() {
		return value;
	}
}
