package euler;

import static math.Primes.isPrime;

public class E46 {

    public static void start() {

        long n = 1;
        long probablePrime = 2;
        long probableSquare = 1;

        boolean found = false;

        do {
            n += 2;
            found = true;

            if (!isPrime(n)) {
                found = false;
                probableSquare = 1;
                probablePrime = n - 2 * probableSquare * probableSquare;

                while (probablePrime > 0 && !found) {
                    if (isPrime(probablePrime)) {
                        found = true;
                    }
                    probableSquare++;
                    probablePrime = n - 2 * probableSquare * probableSquare;
                }
            }

        } while (found);

        System.out.println(n);

    }
}
