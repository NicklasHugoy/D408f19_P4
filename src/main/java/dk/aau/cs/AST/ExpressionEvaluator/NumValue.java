package dk.aau.cs.AST.ExpressionEvaluator;

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
	public Float getValue() {
		return value;
	}
}
