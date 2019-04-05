package dk.aau.cs.AST.ExpressionEvaluator;

import dk.aau.cs.Exceptions.OperationNotSupportedException;

public class VectorValue implements TempValue<Vector>{
	private Vector vector;

	public VectorValue(Vector vector) {
		this.vector = vector;
	}

	@Override
	public VectorValue add(TempValue<Vector> other) {
		Vector newVector = new Vector(
				vector.getX()+other.getValue().getX(),
				vector.getY()+other.getValue().getY(),
				vector.getZ()+other.getValue().getZ());
		return new VectorValue(newVector);
	}

	@Override
	public VectorValue minus(TempValue<Vector> other) {
		Vector newVector = new Vector(
				vector.getX()-other.getValue().getX(),
				vector.getY()-other.getValue().getY(),
				vector.getZ()-other.getValue().getZ());
		return new VectorValue(newVector);
	}

	@Override
	public VectorValue divide(TempValue<Vector> other) {
		throw new OperationNotSupportedException("Can't divide vectors");
	}

	@Override
	public TempValue times(TempValue<Vector> other) {
		throw new OperationNotSupportedException("Can't multiply vectors");
	}

	@Override
	public TempValue and(TempValue<Vector> rightValue) {
		throw new OperationNotSupportedException("'And' operation not supported on vector");
	}

	@Override
	public TempValue or(TempValue<Vector> rightValue) {
		throw new OperationNotSupportedException("'Or' operation not supported on vector");
	}

	@Override
	public TempValue equal(TempValue<Vector> rightValue) {
		return new BoolValue(vector.equals(rightValue.getValue()));
	}

	@Override
	public TempValue inEqual(TempValue<Vector> rightValue) {
		return new BoolValue(!vector.equals(rightValue.getValue()));
	}

	@Override
	public Vector getValue() {
		return vector;
	}
}
