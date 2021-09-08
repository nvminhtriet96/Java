package exercise3;

import java.util.Scanner;

public class FrequentNumber {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the size of array");
		int n = scanner.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter the element " + (i + 1));
			arr[i] = scanner.nextInt();		
		}
		
		System.out.println("Enter the else you want to check");
		
		int check = scanner.nextInt();
		
		int count = 0;
		
		String string = "";
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == check) {
				count ++;
				string += i + " ";
			}
		}
		
		System.out.println("Amount of frequence: " + count);
		System.out.println("Index: " + string);
		
	}

}
