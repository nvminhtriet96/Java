package exercise;

public class Test {
	public static void main(String[] args) {
		// Create an instance of Calculator
		Calculator calculator = new Calculator();
		// Calls method
		int number1 = 20, number2 = 2;

		System.out.println("Sum: " + calculator.sum(number1, number2));
		System.out.println("Subtraction: " + calculator.sub(number1, number2));
		System.out.println("Multiplication: " + calculator.mul(number1, number2));
		System.out.println("Division: " + calculator.div(number1, number2));
	}
}

