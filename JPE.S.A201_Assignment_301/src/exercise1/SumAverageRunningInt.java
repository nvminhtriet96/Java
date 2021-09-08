package exercise1;

public class SumAverageRunningInt {
	public static void main(String[] args) {
		int lowerBound = 1;
		int upperBound = 100;
		int sum = 0;
		
		for(int i = lowerBound; i <= upperBound; i++) {
			sum += i;
		}
		
		System.out.println("Average of all 100 first numbers: " + sum/upperBound);
	}

}
