package dk.aau.cs.AST.ExpressionEvaluator;

import java.util.Objects;

public class Vector {
	private float x;
	private float y;
	private float z;

	public Vector(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Vector vector = (Vector) o;
		return Float.compare(vector.x, x) == 0 && Float.compare(vector.y, y) == 0 && Float.compare(vector.z, z) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
	}
}
