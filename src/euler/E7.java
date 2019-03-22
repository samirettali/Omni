package euler;

import static math.Primes.nthPrime;

/**
 * Created by Sam on 13/03/2017.
 */
public class E7 {

    /*By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

    What is the 10 001st prime number?*/

    public static void start() {
        System.out.println(nthPrime(10001));
    }
}
