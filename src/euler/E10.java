package euler;

import static math.Primes.isPrime;

/**
 * Created by Sam on 14/03/2017.
 */
public class E10 {

    public static void start() {
        long limit = 2000000, sum = 5, i = 5;

        while (i <= limit) {
            if (isPrime(i))
                sum += i;
            i += 2;
        }
        System.out.println(sum);
    }

    public static void startOptimized() {
        long limit = 2000000, sum = 5, i = 5;

        while (i <= limit) {
            if (isPrime(i))
                sum += i;
            i += 2;
            if (i <= limit && isPrime(i))
                sum += i;
            i += 4;
        }
        System.out.println(sum);
    }
}
