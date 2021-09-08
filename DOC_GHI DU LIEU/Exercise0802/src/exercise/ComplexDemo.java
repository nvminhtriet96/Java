package exercise;

public class ComplexDemo {
	public static void main(String[] args) {
		// Create two instances of Complex class
		Complex currentNumber = new Complex(1000, 1200);
		Complex otherNumber = new Complex(600, 800);
		// Call add method
		Complex resultNumber = currentNumber.add(otherNumber);
		// Displays result
		System.out.println(resultNumber);
	}
}