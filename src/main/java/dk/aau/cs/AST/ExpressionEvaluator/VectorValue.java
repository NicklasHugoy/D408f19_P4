package dk.aau.cs.AST.ExpressionEvaluator;

import dk.aau.cs.Exceptions.OperationNotSupportedException;

public class VectorValue implements IValue<Vector> {
	private Vector vector;

	public VectorValue(Vector vector) {
		this.vector = vector;
	}

	@Override
	public VectorValue add(IValue<Vector> other) {
		Vector newVector = new Vector(
				vector.getX()+other.getValue().getX(),
				vector.getY()+other.getValue().getY(),
				vector.getZ()+other.getValue().getZ());
		return new VectorValue(newVector);
	}

	@Override
	public VectorValue minus(IValue<Vector> other) {
		Vector newVector = new Vector(
				vector.getX()-other.getValue().getX(),
				vector.getY()-other.getValue().getY(),
				vector.getZ()-other.getValue().getZ());
		return new VectorValue(newVector);
	}

	@Override
	public <T> IValue<T> divide(IValue<T> other) {
		if(other instanceof NumValue){
			double scalar = ((NumValue) other).getValue();
			return (IValue<T>) new VectorValue(new Vector(getValue().getX() / scalar, getValue().getY() / scalar, getValue().getZ() / scalar));
		}
		throw new OperationNotSupportedException("Vectors can only be divded with Numbers");
	}

	@Override
	public <T> IValue<T> times(IValue<T> other) {
		if(other instanceof NumValue){
			double scalar = ((NumValue) other).getValue();
			return (IValue<T>) new VectorValue(new Vector(getValue().getX() * scalar, getValue().getY() * scalar, getValue().getZ() * scalar));
		}
		throw new OperationNotSupportedException("Vectors can only be multiplied with Numbers");
	}

	@Override
	public IValue and(IValue<Vector> rightValue) {
		throw new OperationNotSupportedException("'And' operation not supported on vector");
	}

	@Override
	public IValue or(IValue<Vector> rightValue) {
		throw new OperationNotSupportedException("'Or' operation not supported on vector");
	}

	@Override
	public IValue equal(IValue<Vector> rightValue) {
		return new BoolValue(vector.equals(rightValue.getValue()));
	}

	@Override
	public IValue inEqual(IValue<Vector> rightValue) {
		return new BoolValue(!vector.equals(rightValue.getValue()));
	}

	@Override
	public IValue greaterThan(IValue<Vector> rightValue) {
		throw new OperationNotSupportedException("'greater than' not supported for vector");
	}

	@Override
	public IValue lessThan(IValue<Vector> rightValue) {
		throw new OperationNotSupportedException("'less than' not supported for vector");
	}

	@Override
	public IValue sqrt() {
		throw new OperationNotSupportedException("Adding booleans are not supported");
	}

	@Override
	public IValue negate() {
		Vector newVector = new Vector(-vector.getX(), -vector.getY(), -vector.getZ());
		return new VectorValue(newVector);
	}

	@Override
	public Vector getValue() {
		return vector;
	}
}
