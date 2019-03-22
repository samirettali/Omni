package euler;

import static math.Functions.gcd;
import static math.Functions.pow;
import static math.Functions.sqrt;
import static math.Properties.isTriplet;

public class E9 {

    public static void start() {
        long limit = 1000, a, b, c;
        for (a = 1; a < limit; a++) {
            for (b = a; b < limit; b++) {
                if (isTriplet(a, b)) {
                    c = sqrt(pow(a, 2) + pow(b, 2));
                    if (a + b + c == limit)
                        System.out.println(a * b * c);

                }
            }
        }
    }

    public static void startOptimized() {
        long limit = 1000 / 2, mLimit = sqrt(limit) - 1, m, k, sm, d, n, a, b, c;
        for (m = 2; m <= mLimit; m++) {
            if (limit % m == 0) {
                sm = limit / m;
                while (sm % 2 == 0)
                    sm /= 2;
                if (m % 2 == 1)
                    k = m + 2;
                else
                    k = m + 1;
                while (k < 2 * m && k <= sm) {
                    if (sm % k == 0 && gcd(k, m) == 1) {
                        d = limit / (k * m);
                        n = k - m;
                        a = d * (m * m - n * n);
                        b = 2 * d * m * n;
                        c = d * (m * m + n * n);
                        System.out.println(a * b * c);
                    }
                    k += 2;
                }
            }
        }

    }
}
