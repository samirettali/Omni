package math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

import static math.Functions.pow;
import static math.Primes.isPrime;
import static misc.Strings.isPalindrome;
import static misc.Strings.reverse;

/* TODO
 * Pronic numbers
 * Harshad numbers
 */

public class Properties {

	/**
	 * A composite number is a positive integer that has at least one divisor other than 1 and itself.
	 * @param n the number to test
	 * @return true if n is composite, false otherwise
	 */
	public static boolean isComposite(long n) {
		return Factors.getFactors(n).size() == 3;
	}

	/**
	 * A highly composite number is a positive integer with more divisors than any smaller positive integer has.
	 * @param n the number to test
	 * @return true if n is highly composite, false otherwise
	 */
	public static boolean isHighlyComposite(long n) {
		long i = 1;
		boolean found = false;
		long divisors = Factors.getFactorsNumber(n);

		while (i < n && !found) {
			if (divisors <= Factors.getFactorsNumber(i))
				found = true;
			i++;
		}
		return !found;
	}

	/**
	 * A semiprime number is a natural number that is the product of two prime numbers.
	 * @param n the number to test
	 * @return true if n is semiprime, false otherwise
	 */
	public static boolean isSemiPrime(long n) {
		assert n > 1;
		return !isPrime(n) && Factors.getPrimeFactors(n).size() <= 2;
	}

	/**
	 * Amicable numbers are two different numbers in which the sum of the proper divisors of each is equal to the
	 * other number.
	 * @param n the first number to test
	 * @param m the second number to test
	 * @return true if n and m are amicable, false otherwise
	 */
	public static boolean areAmicable(long n, long m) {
		assert n > 1;
		assert m > 1;
		return n != m && !isPrime(n) && !isPrime(m) && Factors.getFactorsSum(n) == m && Factors.getFactorsSum(m) == n;
	}

	/**
	 * Given one number, returns its "friend"
	 * @param n the number to search the friend
	 * @return positive long if n has a "friend", -1 otherwise
	 */
	public static long getAmicable(long n) {
		assert n > 1;
		long m = Factors.getFactorsSum(n);

		if (areAmicable(n, m))
			return m;

		return -1;
	}

	/**
	 * A perfect number is a number that is equal to the sum of its proper positive divisors.
	 * @param n the number to test
	 * @return true if n is perfect, false otherwise
	 */
	public static boolean isPerfect(long n) {
		if (n > 1)
			return !isPrime(n) && n == Factors.getFactorsSum(n);
		return false;
	}

	/**
	 * A multiply perfect number is a number that is equal to the sum of its proper positive divisors.
	 * @param n the number to test
	 * @return true if n is perfect, false otherwise
	 */
	// TODO fix
	public static boolean isMultiplyPerfect(long n, long k) {
		assert n > 0;
		assert k > 0;
		return ((double) (Factors.getAllFactorsSum(n)) / (double) n) == (double) k;
	}

	/**
	 * A deficient number is a number that is smaller than the sum of its proper positive divisors.
	 * @param n the number to test
	 * @return true if n is deficient, false otherwise
	 */
	public static boolean isDeficient(long n) {
		if (n > 1)
			return !isPrime(n) && n > Factors.getFactorsSum(n);
		return false;
	}

	/**
	 * An abundant number is a number that is greater than the sum of its proper positive divisors.
	 * @param n the number to test
	 * @return true if n is abundant, false otherwise
	 */
	public static boolean isAbundant(long n) {
		if (n > 1)
			return !isPrime(n) && n < Factors.getFactorsSum(n);
		return false;
	}

	// various
	public static void kaprekar(String n) {
		char[] array = n.toCharArray();

		for (int i = 0; i < n.length(); i++)
			Arrays.sort(array);
	}

	public static boolean isTriplet(long a, long b) {

		if (a == b)
			return false;

		long a2 = pow(a, 2);
		long b2 = pow(b, 2);
		long c2 = a2 + b2;

		if (pow((int) Math.sqrt(c2), 2) == c2)
			return true;
		return false;
	}

	public static long nthTriangle(long n) {
		return (n * n + n) / 2;
	}

	/**
	 * Conversion from base 10 to another base
	 * @param number the number to be converted
	 * @param base the base to convert the number to
	 * @return String containing the converted number
	 */
	public static String baseConversion(long number, int base) {
		String numberString = Long.toString(number);
	    return Long.toString(Long.parseLong(numberString, 10), base);
	}

	/**
	 * A pandigital number is an integer that in a given base has among its significant digits each digit used in the
	 * base at least once.
	 * @param number the number to test, must be a String because of Java numbers representation
	 * @param base the base to test the number to
	 * @return true if the number is pandigital, false otherwise
	 */
	public static boolean isPandigital(String number, int base) {
		assert base <= 36;
		String numbers = "1023456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String baseNumbers = numbers.substring(0, base);

        for (int i = 0; i < base; i++) {
			if (!number.contains(Character.toString(baseNumbers.charAt(i))))
				return false;
		}
		return true;
	}

	public static boolean isPandigitalNoZero(String number, int base) {
		assert base <= 36;
		String numbers = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String baseNumbers = numbers.substring(0, base);

		for (int i = 0; i < base; i++) {
			if (!number.contains(Character.toString(baseNumbers.charAt(i))))
				return false;
		}
		return true;
	}

	public static long triangularTriplet(long a, long b) {
		double c = Math.sqrt(a * a + b * b);
		if (c != Math.floor(c))
			c = 0;
		return (long) c;
	}

	public static boolean isSquare(long n) {
		assert n > 0;
		double test = (Math.sqrt(n));
		return test == (long) test;
	}

	public static boolean isTriangular(long n) {
		assert n > 0;
		double test = (Math.sqrt(1 + 8 * n) + 1) / 2;
		return test == (long) test;
	}

	public static boolean isPentagonal(long n) {
		assert n > 0;
		double test = (Math.sqrt(1 + 24 * n) + 1) / 6;
		return test == (long) test;
	}

	public static boolean isHexagonal(long n) {
		assert n > 0;
		double test = (Math.sqrt(1 + 8 * n) + 1) / 4;
		return test == (long) test;
	}

	public static boolean isHeptagonal(long n) {
		assert n > 0;
		double test = (Math.sqrt(9 + 40 * n) + 3) / 10;
		return test == (long) test;
	}

	public static boolean isOctagonal(long n) {
		assert n > 0;
		double test = (Math.sqrt(1 + 3 * n) + 1) / 3;
		return test == (long) test;
	}

	public static boolean isLyachel(long n) {
		long count = 0;
		BigInteger big = new BigInteger(Long.toString(n));

		do {
			big = big.add(new BigInteger(reverse(big.toString())));
			count++;
		} while (count < 50 && !isPalindrome(big.toString()));

		return count == 50;
	}


	/**
	 * A k-smooth number is an integer which factors completely into prime numbers smaller than k.
	 * @param n the number to test against k
	 * @param k
	 * @return true if n is k-smooth, false otherwise
	 */
	public static boolean isKSmooth(long n, long k) {
		ArrayList<Long> primeFactors = Factors.getPrimeFactors(n);
		for (Long primeFactor : primeFactors) {
			if (primeFactor > k)
				return false;
		}
		return true;
	}
}
