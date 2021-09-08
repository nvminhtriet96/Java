package fa.training.assignment1;

import java.util.Scanner;

public class CircleExercise {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Radius = ");
		String input = sc.nextLine();
		System.out.println("Perimeter is = " + perimeter(input));
		System.out.println("Area is = " + area(input));
		sc.close();

	}
	public static double perimeter(String a) {
		double a1 = Double.parseDouble(a);
		final double MATH_PI = Math.PI;
		return MATH_PI*a1*2;
	}
	public static double area(String a) {
		double a1 = Double.parseDouble(a);
		final double MATH_PI = Math.PI;
		return MATH_PI*a1*a1;
	}
	
}
