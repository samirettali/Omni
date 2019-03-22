package math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static math.Functions.gcd;
import static math.Functions.lcm;

public class Fraction {

	private long numerator;
	private long denominator;
	private Fraction fNumerator;
	private Fraction fDenominator;

	public Fraction(long numerator, long denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public Fraction(Fraction fNumerator, Fraction fDenominator) {
		this.fNumerator = fNumerator;
		this.fDenominator = fDenominator;
	}

	public Fraction(long numerator, Fraction fDenominator) {
		this.numerator = numerator;
		this.fDenominator = fDenominator;
	}

	public Fraction(Fraction fNumerator, long denominator) {
		this.fNumerator = fNumerator;
		this.denominator = denominator;
	}

	public Fraction(long numerator) {
		this(numerator, 1);
	}

	public Fraction(Fraction fraction) {
		this(fraction, 1);
	}

	public Fraction() {
		this(1, 1);
	}

	public long getNumerator() {
		return numerator;
	}

	public Fraction getFNumerator() {
		if (fNumerator == null)
			return new Fraction(numerator);
		else
			return fNumerator;
	}

	public long getDenominator() {
		return denominator;
	}

	public Fraction getFDenominator() {
		if (fDenominator == null)
			return new Fraction(1, numerator);
		else
			return fDenominator;
	}

	public void setNumerator(long numerator) {
		this.numerator = numerator;
	}

	public void setDenominator(long denominator) {
		this.denominator = denominator;
	}

	public double getValue() {
		double n;
		double d;

		if (fNumerator != null)
			n = fNumerator.getValue();
		else
			n = denominator;
		if (fDenominator != null)
			d = fDenominator.getValue();
		else
			d = denominator;

		return n / d;
	}

	public Fraction sum(Fraction fraction) {
		long newDenominator = lcm(denominator, fraction.getDenominator());
		return new Fraction(numerator * (newDenominator / denominator), fraction.getNumerator() * (newDenominator / fraction.getDenominator()));
	}

	public Fraction sum(long n) {
		return sum(new Fraction(n));
	}

	public Fraction mul(Fraction fraction) {
		return new Fraction(this.numerator * fraction.getNumerator(), this.denominator * fraction.getDenominator());
	}

	public Fraction simplify() {
		long gcd = gcd(numerator, denominator);
		return new Fraction(numerator / gcd, denominator / gcd);
	}

	public String toString() {
		return numerator + " / " + denominator + " = " + getValue();
	}

	public static Fraction toFraction(double n) {
		long possibleDenominator = 1;

		while (n * possibleDenominator != (long) (n * possibleDenominator))
			possibleDenominator++;

		return new Fraction((long) (possibleDenominator * n), possibleDenominator).simplify();
	}

	public static Fraction toFraction(BigDecimal n) {
		BigDecimal possibleDenominator = new BigDecimal(1);

		while (n.multiply(possibleDenominator).round(new MathContext(2, RoundingMode.HALF_UP)).compareTo(n.multiply(possibleDenominator)) != 0)
			possibleDenominator = possibleDenominator.add(new BigDecimal(1));

		return new Fraction(possibleDenominator.multiply(n).longValue(), possibleDenominator.longValue()).simplify();
	}
}
