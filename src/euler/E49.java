package euler;

import static math.Primes.isPrime;
import static misc.Strings.isPermutation;

public class E49 {

    public static void start() {

        int m;
        int k;
        int n = 1488;
        boolean found = false;

        do {
            m = n + 3330;
            k = m + 3330;

            if (isPrime(n) && isPrime(m) && isPrime(k) && isPermutation(Integer.toString(n), Integer.toString(m), Integer.toString(k)))
                found = true;

            n++;
        } while (!found);

        System.out.println((n - 1) + "" + m + "" + k);
    }

}
