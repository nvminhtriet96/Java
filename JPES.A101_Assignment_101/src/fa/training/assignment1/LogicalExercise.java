package fa.training.assignment1;

import java.util.Scanner;

public class LogicalExercise {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input first integer: ");
		String input1 = sc.nextLine();
		System.out.println("Input second integer: ");
		String input2 = sc.nextLine();
		LogicalExercise(input1, input2);
		sc.close();

	}
	public static void LogicalExercise(String intput1, String input2) {
		double a = Double.parseDouble(intput1);
		double b = Double.parseDouble(input2);
		System.out.println(a != b);
		System.out.println(a < b);
		System.out.println(a <= b);
	}
}
