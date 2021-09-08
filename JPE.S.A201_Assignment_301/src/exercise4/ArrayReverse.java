package exercise4;

public class ArrayReverse {

	public static void main(String[] args) {
        int[] myIntArray = { 43, 32, 53, 23, 12, 34, 3, 12, 43, 32 };
        int[] array = arrayReverse(myIntArray);
        System.out.print("Original Array: ");
        for (int i = 0; i < myIntArray.length; i++) {
            if (i < myIntArray.length-1)
        	System.out.print(myIntArray[i] + ", ");
            else {
                System.out.println(myIntArray[i]);
            }
        }
        System.out.print("Reversed Array: ");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length-1)
        	System.out.print(array[i] + ", ");
            else {
                System.out.println(array[i]);
            }
        }

	}
	public static int[] arrayReverse(int[] array) {
		int n = 0;
		n = array.length;
		int[] arrayReverse = new int[n];
		int i = n;
		int k = 0;
		for(i = n-1; i>=0; i--) {
			arrayReverse[k] = array[i];
			k++;
		}
		return arrayReverse;
	}

}
