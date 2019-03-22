package euler;

import java.util.ArrayList;

import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.lang.Math.floor;
import static math.Primes.primesUpTo;

/**
 * Created by Sam on 13/03/2017.
 */
public class E5 {

    public static void start() {
        // prime factors with bigger exponents
        System.out.println(2 * 2 * 2 * 2 * 3 * 3 * 5 * 7 * 11 * 13 * 17 * 19);
    }

    public static void startOptimized() {
        long k = 20, n = 1, limit = (long) Math.sqrt(k) + 1;
        int i = 0;
        ArrayList<Long> primes = primesUpTo(k), exp = new ArrayList<Long>();
        long size = primes.size();
        boolean check = true;

        while (i < size) {
            exp.add(1l);
            if (check) {
                if (primes.get(i) <= limit)
                    exp.set(i, (long) floor(log(k) / log(primes.get(i))));
                else
                    check = false;
            }
            n *= pow(primes.get(i), exp.get(i));
            i++;
        }

        System.out.println(n);

    }
}
