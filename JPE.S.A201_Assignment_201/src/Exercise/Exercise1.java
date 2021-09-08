package Exercise;

public class Exercise1 {

	public static void calculator() {
		System.out.println((101 + 0) / 3);
		System.out.println(3.0e-6 * 10000000.1);
		System.out.println(true && true);
		System.out.println(false && true);
		System.out.println((false && false) || (true && true));
		System.out.println((false || false) && (true && true));
	}
	
	public static void main(String[] args) {
		Exercise1.calculator();
	}

}
