package euler;

import static math.Properties.triangularTriplet;

public class E39 {

    public static void start() {
        long max = 0, maxn = 0, current, c;

        for (long i = 0; i <= 1000; i++) {
            current = 0;
            for (long a = 1; a < i; a++) {
                for (long b = 1; b < a; b++) {
                    c = triangularTriplet(a, b);
                    if (c != 0 && a + b + c == i)
                        current++;
                }
            }
            if (current > max) {
                max = current;
                maxn = i;
            }
        }
        System.out.println(maxn);
    }
}

