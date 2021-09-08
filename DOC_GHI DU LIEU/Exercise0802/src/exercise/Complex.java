package exercise;

public class Complex {
	private double realPart;
	private double imaginaryPart;

	public Complex() {
		this.realPart = 0.0;
		this.imaginaryPart = 0.0;
		System.out.println("Complex without param!");
	}

	public Complex(double realPart, double imaginaryPart) {
		this();
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
		System.out.println("Complex with two params!");
	}

	public double getRealPart() {
		return realPart;
	}

	public void setRealPart(double realPart) {
		this.realPart = realPart;
	}

	public double getImaginaryPart() {
		return imaginaryPart;
	}

	public void setImaginaryPart(double imaginaryPart) {
		this.imaginaryPart = imaginaryPart;
	}

	/**
	 * This method will find the sum of the current complex number and the passed
	 * complex number.
	 *
	 * @param otherNumber
	 * @return a new Complex number which is the sum of the two.
	 */
	public Complex add(Complex otherNumber) {
		double resultRealPart = this.realPart + otherNumber.realPart;
		double resultImaginaryPart = this.imaginaryPart + otherNumber.imaginaryPart;
		Complex resultNumber = new Complex(resultRealPart, resultImaginaryPart);
		return resultNumber;
	}


}