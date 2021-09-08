package exercise2;

import java.util.Scanner;

public class ArrayContains {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the size of array");
		int n =  scanner.nextInt();
		
		scanner.nextLine();
		
		String arr[] = new String[n];
		
		for(int i = 0; i < arr.length; i++ ) {
			System.out.println("Enter the element " + i );
			arr[i] = scanner.nextLine();
		}
		
		System.out.println("element in array: ");
		
		for (String e : arr) {
			System.out.println(e);
		}
		
		System.out.println("Enter the element you want to check");
		
		String checkString = scanner.nextLine();
		
		boolean flag = false ;
		
		for (String e : arr) {
			if(checkString.equals(e)) {
				System.out.println("Contained");
				flag = true;
				break;				
			}
		}
		
		if(!flag) {
			System.out.println("no contain");
		}
	}

}
