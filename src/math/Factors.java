package math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Factors {

	public static ArrayList<Long> getFactors(long n) {
		assert n > 0;
		int inc = n % 2 == 0 ? 1 : 2;

		long limit = (long) Math.sqrt(n);
		ArrayList<Long> factors = new ArrayList<>();

		for (long i = 1; i <= limit; i += inc) {
			if (n % i == 0) {
				factors.add(i);
				if (n / i != i)
                    factors.add(n / i);
			}
		}

		return factors;
	}

	public static ArrayList<Long> getProperFactors(long n) {
		ArrayList<Long> factors = getFactors(n);
		factors.remove(new Long(n));
		return factors;
	}

	public static ArrayList<Long> getPrimeFactors(long n) {
		assert n > 1;

		long number = n;
		ArrayList<Long> factors = new ArrayList<>();

		if (Primes.isPrime(n))
			factors.add(n);
		else {
			for (long i = 2; i <= n / i; i++) {
				while (n % i == 0) {
					n /= i;
					factors.add(i);
				}
			}

			if (n > 1)
				factors.add(n);


		}

		return factors;
	}

    public static Long getBiggestPrimeFactor(long n) {
        return Collections.max(getPrimeFactors(n));
    }


	// number of factors

	public static long getFactorsNumber(long n) {
		assert n > 0;
		return getFactors(n).size();
	}

	public static long getPrimeFactorsNumber(long n) {
		assert n > 0;
		return getPrimeFactors(n).size();
	}

	public static long getFactorsSum(long number) {
		long sqrtOfNumber = (long) Math.sqrt(number);
		long sum = 1;

		// if the number is a perfect square
		// count the squareroot once in the sum of factors
		if (number == sqrtOfNumber * sqrtOfNumber) {
			sum += sqrtOfNumber;
			sqrtOfNumber--;
		}

		for (int i = 2; i <= sqrtOfNumber; i++) {
			if (number % i == 0) {
				sum = sum + i + (number / i);
			}
		}

		return sum;
	}

	public static long getAllFactorsSum(long n) {
		return getFactorsSum(n) + n;
	}

}
