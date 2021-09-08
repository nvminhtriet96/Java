package exercise;

public class Circle {
	private double radius;

	public Circle() {
		this.radius = 1.0;
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	/**
	 * Calculate circle area based on radius.
	 * 
	 * @return the area value of circle.
	 */
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
}