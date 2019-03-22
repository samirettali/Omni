package euler;

import static math.Primes.isPrime;
import static math.Primes.isTruncatablePrime;

/**
 * @author Samir Ettali
 **/
public class E37 {
    public static void start() {
        int count = 0;
        long counter = 0;
        long sum = 0;
        while (count < 11) {
            if (isTruncatablePrime(counter)) {
                sum += counter;
                count++;
            }
            counter++;
        }
        System.out.println(sum);
    }
}
