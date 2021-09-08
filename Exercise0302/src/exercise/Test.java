package exercise;

public class Test {
	public static void main(String[] args) {
		// Create an instance of Circle
		Circle circle = new Circle(12);
		// Calls method
		System.out.println(String.format("Area of the circle %.2f", circle.getArea()));
	}
}