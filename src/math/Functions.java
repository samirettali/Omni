package math;

import java.math.BigInteger;
import java.util.ArrayList;

public class Functions {

	public static long factorial(long n) {
		long factorial = 1;

		for (long i = 2; i <= n; i++)
			factorial *= i;

		return factorial;
	}

	public static BigInteger bigFactorial(long n) {
		BigInteger factorial = new BigInteger("1");

		for (long i = 1; i <= n; i++)
			factorial = factorial.multiply(new BigInteger(Long.toString(i)));

		return factorial;
	}

	public static BigInteger factorial(BigInteger n) {
		BigInteger factorial = new BigInteger("1");

		for (BigInteger i = new BigInteger("1"); i.compareTo(n) < 1; i.add(new BigInteger("1")))
			factorial = factorial.multiply(i);

		return factorial;
	}

	public static long gcd(long a, long b) {
		long remainder;
		while (b != 0) {
			remainder = a % b;
			a = b;
			b = remainder;
		}
		return a;
	}

	public static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}

	public static ArrayList<Long> collatzSequence(long n) {
		assert n > 0;

		ArrayList<Long> sequence = new ArrayList<Long>();

		sequence.add(n);

		while (n != 1) {

			if (n % 2 == 0)
				n = n / 2;
			else
				n = 3 * n + 1;
			sequence.add(n);
		}

		return sequence;
	}

	public static long binomial(long a, long b) {
		assert a >= b;

		return bigBinomial(a, b).longValue();
	}

	public static BigInteger bigBinomial(long a, long b) {
		assert a >= b;

		return bigFactorial(a).divide(bigFactorial(b).multiply(bigFactorial(a - b)));
	}

	public static long digitsSum(BigInteger number) {
		String s = number.toString();
		int size = s.length();
		long sum = 0;
		for (int i = 0; i < size; i++)
			sum += s.charAt(i) - '0';

		return sum;
	}

	// mean
	public static double mean(int[] vector) {
		int size = vector.length, sum = 0;
		for (int i = 0; i < size; i++)
			sum += vector[i];
		return sum / size;
	}

	public static long sumSequence(long start, long end) {
		assert start >= 0;
		assert end >= 0;
		return (start + end) * (end - start + 1) / 2;
	}

	public static long sumDivisibleBy(long n, long start, long end) {
		return n * sumSequence(start, end / n);
	}

	public static double log(double x, double base) {
		return Math.log(x) / Math.log(base);
	}

	public static int log(int x, int base) {
		return (int) log((double) x, (double) base);
	}

	public static long smallestPowerOfTwo(long n) {
		long exponent = 0, power = 1;
		while (power < n) {
			exponent++;
			power = (long) Math.pow(2, exponent);
		}

		return (long) Math.pow(2, exponent - 1);
	}

	public static int sqrt(int x) {
		if (x < 0)
			throw new IllegalArgumentException("Square root of negative number");
		int y = 0;
		for (int i = 32768; i != 0; i >>>= 1) {
			y |= i;
			if (y > 46340 || y * y > x)
				y ^= i;
		}
		return y;
	}

	// Returns floor(sqrt(x)), for x >= 0.
	public static long sqrt(long x) {
		if (x < 0)
			throw new IllegalArgumentException("Square root of negative number");
		long y = 0;
		for (long i = 1L << 31; i != 0; i >>>= 1) {
			y |= i;
			if (y > 3037000499L || y * y > x)
				y ^= i;
		}
		return y;
	}

	public static BigInteger sqrt(BigInteger x) {
		if (x.signum() == -1)
			throw new IllegalArgumentException("Square root of negative number");
		BigInteger y = BigInteger.ZERO;
		for (int i = (x.bitLength() - 1) / 2; i >= 0; i--) {
			y = y.setBit(i);
			if (y.multiply(y).compareTo(x) > 0)
				y = y.clearBit(i);
		}
		return y;
	}

	// Returns x to the power of y, throwing an exception if the result overflows an int.
	public static int pow(int x, int y) {
		if (x < 0)
			throw new IllegalArgumentException("Negative base not supported");
		if (y < 0)
			throw new IllegalArgumentException("Negative exponent");
		int z = 1;
		for (int i = 0; i < y; i++) {
			if (Integer.MAX_VALUE / z < x)
				throw new ArithmeticException("Overflow");
			z *= x;
		}
		return z;
	}

	// Returns x to the power of y, throwing an exception if the result overflows an int.
	public static long pow(long x, long y) {
		if (x < 0)
			throw new IllegalArgumentException("Negative base not supported");
		if (y < 0)
			throw new IllegalArgumentException("Negative exponent");
		int z = 1;
		for (int i = 0; i < y; i++) {
			if (Long.MAX_VALUE / z < x)
				throw new ArithmeticException("Overflow");
			z *= x;
		}
		return z;
	}

	// number conversion between different bases

	public static long binToDec(String bin) {
		int i;
		long dec = 0;
		for (i = 0; i < bin.length(); i++)
			if (bin.charAt(bin.length() - i - 1) == '1')
				dec += Math.pow(2, i);
		return dec;
	}

	public static String decToBin(long dec) {
		String bin = "";
		while (dec > 0) {
			bin = (dec % 2) + bin;
			dec /= 2;
		}
		return bin;
	}

	public static ArrayList<ArrayList<Integer>> combinations(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (n == 0 || k < n)
			return result;

		ArrayList<Integer> item = new ArrayList<Integer>();
		dfs(k, n, 1, item, result);
		return result;
	}

	private static void dfs(int n, int k, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res) {
		if (item.size() == k) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
		for (int i = start; i <= n; i++) {
			item.add(i);
			dfs(n, k, i + 1, item, res);
			item.remove(item.size() - 1);
		}
	}

	public static ArrayList<ArrayList<Integer>> permutations(ArrayList<Integer> list) {
		ArrayList<ArrayList<Integer>> perms = new ArrayList<ArrayList<Integer>>();
		permutations(perms, list, list.size() - 1);
		return perms;
	}

	private static void permutations(ArrayList<ArrayList<Integer>> perms, ArrayList<Integer> list, int n) {
		if (n == 0)
			perms.add(clone(list));
		else
			for (int i = 0; i <= n; i++) {
				permutations(perms, list, n - 1);
				swap(list, n % 2 == 0 ? i : 0, n);
			}
	}

	// function used to get a clone of an ArrayList
	private static ArrayList<Integer> clone(ArrayList<Integer> list) {
		ArrayList<Integer> newList = new ArrayList<Integer>();
		for (int n : list)
			newList.add(n);
		return newList;
	}

	private static void swap(ArrayList<Integer> list, int i, int j) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	public static double map(double value, double start, double end, double min, double max) {
		assert value >= start;
		assert value <= end;
		return (value / end) * max;
	}

	public static int reverse(int n) {
		long sum = 0;
		while (n != 0) {
			int s = n % 10;
			sum = sum * 10 + s;
			n /= 10;
		}

		if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)
			return 0;

		return (int) sum;
	}
}
