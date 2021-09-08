package fa.training.assignment1;

import java.util.Scanner;

public class RectangleExercise {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Width = ");
		String input1 = sc.nextLine();
		System.out.println("Height = ");
		String input2 = sc.nextLine();
		System.out.println("Area is " + input1 + "*" + input2 +" = " + area(input1,input2));
		System.out.println("Perimeter is 2*("+ input1+" + " + input2 +") = " + perimeter(input1,input2));
		sc.close();

	}
	public static double perimeter(String a1, String a2) {
		double b1 = Double.parseDouble(a1);
		double b2 = Double.parseDouble(a2);
		return 2*(b1+b2);
	}
	public static double area(String a1, String a2) {
		double b1 = Double.parseDouble(a1);
		double b2 = Double.parseDouble(a2);
		return b1*b2;
	}
}
