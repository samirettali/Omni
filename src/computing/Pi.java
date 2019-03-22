package computing;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Random;

import static math.Functions.gcd;

public class Pi {
	public static final MathContext PRECISION = new MathContext(4096);

	public static void random(long extractions) {
		Random random = new Random();
		int count = 0;
		long a, b;

		for (long i = 0; i < extractions; i++) {
			a = random.nextLong();
			b = random.nextLong();

			if (a < 0)
				a *= -1;
			if (b < 0)
				b *= -1;
			if (gcd(a, b) == 1)
				count++;
		}

		System.out.println(Math.sqrt(6 / (count / (double) extractions)));
	}

	/**
	 * 1 - 1/3 + 1/5 - 1/7 + 1/9 - ... = pi / 4
	 * @param steps the number of steps to execute
	 * @return pi
	 */
	public static BigDecimal leibniz(long steps) {
		BigDecimal pi = new BigDecimal("0");
		BigDecimal one = new BigDecimal("1");
		BigDecimal two = new BigDecimal("2");
		BigDecimal three = new BigDecimal("3");

		for (long i = 0; i < steps / 2; i+=2) {
			pi = pi.add(one.divide(one.add(two.multiply(new BigDecimal(Long.toString(i)))), PRECISION));
			pi = pi.subtract(one.divide(three.add(two.multiply(new BigDecimal(Long.toString(i)))), PRECISION));
			// pi += 1d / (1 + 2 * i);
			// pi -= 1d / (3 + 2 * i);
		}
		return pi.multiply(new BigDecimal("4"));
	}
}

