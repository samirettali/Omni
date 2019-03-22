package math;

import java.math.BigInteger;
import java.util.*;

/* TODO circular prime */
public class Primes {

	public static boolean isPrime(long n) {
		if (n < 2)
			return false;

		if (n == 2 || n == 3)
			return true;

		if (n % 2 == 0 || n % 3 == 0)
			return false;

		long root = (long) Math.sqrt(n) + 1;

		for (long i = 6L; i <= root; i += 6)
			if (n % (i - 1) == 0 || n % (i + 1) == 0)
				return false;

		return true;
	}

	public static long nextPrime(long n) {
		while (!isPrime(++n)) ;
		return n;
	}

	public static boolean isPrime(BigInteger n) {

		if (n.compareTo(new BigInteger("2")) < 0)
			return false;

		if (n.compareTo(new BigInteger("2")) == 0 || n.compareTo(new BigInteger("3")) == 0)
			return true;

		if (n.mod(new BigInteger("2")).equals(new BigInteger("0")) || n.mod(new BigInteger("3")).equals(new BigInteger("0")))
			return false;

		BigInteger root = math.Functions.sqrt(n);
		BigInteger increment = new BigInteger("6"), zero = new BigInteger("0"), one = new BigInteger("1");

		for (BigInteger i = new BigInteger("6"); i.compareTo(root) <= 0; i = i.add(increment))
			if (n.mod(i.subtract(one)).equals(zero) || n.mod(i.add(one)).equals(zero))
				return false;

		return true;
	}

	public static boolean isPrimeRegex(int n) {
		return !new String(new char[n]).matches(".?|(..+?)\\1+");
	}

	public static long nthPrime(long n) {
		assert n > 0;

		if (n == 1)
			return 2;

		if (n == 2)
			return 3;

		long count = 2, i = 5;

		while (count < n) {
			if (isPrime(i))
				count++;
			i += 2;
		}

		return i - 2;
	}

	public static boolean fermatPrimality(long n) {
		assert n > 1;

		if (n == 2)
			return true;

		return (Math.pow(2, n - 1) % n) == 1;
	}

	public static ArrayList<Long> primesUpTo(long limit) {
		assert limit > 1;

		ArrayList<Long> primes = new ArrayList<Long>();

		for (long i = 2; i <= limit; i++)
			primes.add(i);

		for (int i = 0; i < primes.size() - 1; i++) {
			int j = i + 1;
			while (j < primes.size()) {
				if (primes.get(j) % primes.get(i) == 0)
					primes.remove(j);
				else
					j++;
			}
		}

		return primes;
	}

	public static ArrayList<Long> nPrimes(long n) {
		assert n > 0;

		ArrayList<Long> primes = new ArrayList<>();
		long p = 2;
		while (primes.size() < n) {
			if (isPrime(p))
				primes.add(p);
			p++;
		}

		return primes;
	}

	public static void testPrint(long n) {
		for (long i = 0; i <= n; i++)
			if (isPrime(i))
				System.out.println(i);
	}

	public static void test(long n) {
		for (long i = 0; i <= n; i++)
			isPrime(i);
	}

	public static int[] eratostene(int limit) {
		boolean[] isComposite = new boolean[limit + 1];
		for (int i = 2; i * i <= limit; i++) {
			if (!isComposite[i]) {
				for (int j = i; i * j <= limit; j++) {
					isComposite[i * j] = true;
				}
			}
		}
		int numPrimes = 0;
		for (int i = 2; i <= limit; i++) {
			if (!isComposite[i])
				numPrimes++;
		}
		int[] primes = new int[numPrimes];
		int index = 0;
		for (int i = 2; i <= limit; i++) {
			if (!isComposite[i])
				primes[index++] = i;
		}
		return primes;

	}

	public static ArrayList<Integer> eratosteneList(int limit) {
		ArrayList<Integer> primes = new ArrayList<>();
		ArrayList<Boolean> isComposite = new ArrayList<>();

		for (int i = 0; i <= limit; i++)
			isComposite.add(false);

		for (int i = 2; i * i <= limit; i++)
			if (!isComposite.get(i))
				for (int j = i; i * j <= limit; j++)
					isComposite.set(i * j, true);

		int index = 0;

		for (int i = 2; i <= limit; i++)
			if (!isComposite.get(i))
				primes.add(index++, i);

		return primes;

	}

	public static boolean fermatPrimality(BigInteger n) {
		return new BigInteger("2").modPow(n, n).toString() == "2";
	}

	public static boolean isTruncatablePrime(long n) {
		if (n > 9 && isPrime(n)) {
			boolean flag = false;
			long left = n, right = n;
			long lexp = (long) Math.pow(10, (long) Math.log10(n));
			long rexp = 10;
			for (int i = 0; left > 9 && !flag; i++) {
				left = n % lexp;
				right = n / rexp;
				lexp /= 10;
				rexp *= 10;
				if (!isPrime(left) || !isPrime(right))
					flag = true;
			}
			if (!flag)
				return true;
		}
		return false;
	}

}
