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
	public VectorValue divide(IValue<Vector> other) {
		throw new OperationNotSupportedException("Can't divide vectors");
	}

	@Override
	public IValue times(IValue<Vector> other) {
		throw new OperationNotSupportedException("Can't multiply vectors");
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
