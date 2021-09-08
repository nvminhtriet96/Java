package Exercise;

import java.util.Scanner;

public class Exercise3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("Enter the first number");
			int number1 = scanner.nextInt();
			System.out.println("Enter the second number ");
			int number2 = scanner.nextInt();
			System.out.println("Enter the third number");
			int number3 = scanner.nextInt();
			System.out.println("Enter the fourth number");
			int number4 = scanner.nextInt();
			System.out.println("Enter the fiveth number");
			int number5 = scanner.nextInt();
			
			System.out.println("The sum is: " + (number1 + number2 + number3 + number4 + number5));

		} while (true);
	}

}
