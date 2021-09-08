package fa.training.assignment1;

public class ArithmeticExercise2 {

	public static void main(String[] args) {
		System.out.println("125 + 24" + " = " + sum(130,24));
		System.out.println("125 x 24" + " = " + multiply(130,24));
		System.out.println("125 - 24" + " = " + subtract(130,24));
		System.out.println("125 / 24" + " = " + divide(130,24));
		System.out.println("125 % 24" + " = " + remainder(130,24));

	}
	public static int sum(int a, int b) {
		return a+b;
	}
	public static int multiply(int a, int b) {
		return a*b;
	}
	public static int subtract(int a, int b) {
		return a-b;
	}
	public static int divide(int a, int b) {
		return a/b;
	}
	public static int remainder(int a, int b) {
		return a%b;
	}

}
