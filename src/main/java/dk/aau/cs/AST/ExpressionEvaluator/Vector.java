package dk.aau.cs.AST.ExpressionEvaluator;

import java.util.Objects;

public class Vector {
	private double x;
	private double y;
	private double z;

	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Vector vector = (Vector) o;
		return Double.compare(vector.x, x) == 0 && Double.compare(vector.y, y) == 0 && Double.compare(vector.z, z) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
	}
}
