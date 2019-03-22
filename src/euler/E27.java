package euler;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

import static math.Primes.isPrime;

/**
 * Created by samir on 02/04/17.
 */
public class E27 {
    public static void start() {

        int exp, a, b, n, max = 0, val = 0, counter;
        SortedSet<Integer> list;

        for (a = -999; a < 1000; a++) {

            list = new TreeSet<>();

            for (b = -1000; b <= 1000; b++) {

                n = 0;
                counter = 0;
                exp = n * n + a * n + b;

                while (isPrime(Math.abs(exp))) {
                    list.add(exp);
                    counter++;
                    n++;
                    exp = n * n + a * n + b;
                }

                if (counter > max) {
                    max = counter;
                    val = a * b;
                }
            }

        }

        System.out.println(val);
    }

}
