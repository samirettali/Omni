package math;

import java.util.Random;
import java.util.Scanner;

public class SquareRoot {

	public static int sqrt(int x) {

		int res = -1;
		boolean np = false;
		Random rand = new Random();
		int r = rand.nextInt(x) + 1;

		do {
			r = rand.nextInt(x / r) + 1;
			if (r * r < x && (r + 1) * (r + 1) > x)
				np = true;
		} while (r * r != x && !np);

		if (!np)
			res = r;

		return res;
	}

}
