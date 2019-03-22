package math;

/**
 * Complex number representation
 */
public class Complex {

	private double real;
	private double imaginary;

	public Complex(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	public Complex add(Complex n) {
		Complex temp = new Complex(real, imaginary);
		temp.setReal(real + n.getReal());
		temp.setImaginary(imaginary + n.getImaginary());
		return temp;
	}

	public Complex sub(Complex n) {
		Complex temp = new Complex(real, imaginary);
		temp.setReal(real - n.getReal());
		temp.setImaginary(imaginary - n.getImaginary());
		return temp;
	}

	public Complex mult(Complex n) {
		Complex temp = new Complex(this.real, this.imaginary);
		temp.setReal(this.real * n.getReal() - this.imaginary * n.getImaginary());
		temp.setImaginary(this.imaginary * n.getReal() + this.real * n.getImaginary());
		return temp;
	}

	public double abs() {
		return Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
	}

	public static Complex polar(double rho, double theta) {
		return new Complex(rho * Math.cos(theta), rho * Math.sin(theta));
	}

	public void setReal(double real) {
		this.real = real;
	}

	public void setImaginary(double imaginary) {
		this.imaginary = imaginary;
	}

	public double getReal() {
		return this.real;
	}

	public double getImaginary() {
		return this.imaginary;
	}

	@Override
	public String toString() {
		return "(" + this.real + ", " + this.imaginary + ")";
	}
}
