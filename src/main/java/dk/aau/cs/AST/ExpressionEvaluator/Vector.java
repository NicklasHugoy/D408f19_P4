package dk.aau.cs.AST.ExpressionEvaluator;

import java.text.DecimalFormat;
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

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public String toGCode(){
		DecimalFormat df = new DecimalFormat("0.####");
		//return String.format("%.4f", value).replace(',', '.');
		return (" X"+df.format(x)+" Y"+df.format(y)+" Z"+df.format(z)).replace(',', '.');
	}
}
