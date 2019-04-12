package dk.aau.cs.AST.ExpressionEvaluator;

import dk.aau.cs.Exceptions.ImaginaryNumberException;
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
	public <T> IValue<T> divide(IValue<T> other) {
		if(other instanceof NumValue){
			NumValue otherValue = (NumValue) other;
			return (IValue<T>) new NumValue(value / otherValue.getValue());
		}
		else{
			throw new OperationNotSupportedException("NumValue can only be divded with other NumValues");
		}


	}

	@Override
	public <T> IValue<T> times(IValue<T> other) {
		if(other instanceof NumValue){
			NumValue numValue = (NumValue) other;
			return (IValue<T>) new NumValue(value * numValue.getValue());
		}else if(other instanceof  VectorValue){
			Vector vector = (Vector) other.getValue();
			return (IValue<T>) new VectorValue(new Vector(vector.getX() * value, vector.getY() * value, vector.getY() * value));
		}
		throw new OperationNotSupportedException("NumValue can only be * with vector and num");
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
	public IValue sqrt() {
	    if(value == -1)
	        throw new ImaginaryNumberException("imaginary numbers are not supported i.e. sqrt(-1)");

		return new NumValue(Math.sqrt(value));
	}

	@Override
	public IValue negate() {
		return new NumValue(-value);
	}

	@Override
	public Double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.format("%.4f", value).replace(',', '.');
	}
}
