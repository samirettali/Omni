package euler;

import java.util.ArrayList;
import java.util.HashSet;

import static math.Factors.getPrimeFactors;

public class E47 {

    public static void start() {
        long n = 2;
        int len = 4;
        boolean found;
        ArrayList<Long>[] primes;

        do {
            primes = new ArrayList[len];
            for (int i = 0; i < len; i++)
                primes[i] = getPrimeFactors(n + i);
            n++;

            found = true;
            for (int i = 0; i < len && found; i++)
                if (primes[i].size() != len)
                    found = false;

        } while (!found);

        for (int i = 0; i < len; i++)
            System.out.println(primes[i]);
        System.out.println(n - 1);
    }
}
