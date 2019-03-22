package euler;

import misc.Stopwatch;

import java.util.ArrayList;
import java.util.HashSet;

import static math.Primes.isPrime;
import static misc.Strings.rotations;

/**
 * @author Samir Ettali
 **/
public class E35 {
    public static void start() {
        long count = 0;
        for (int i = 0; i < 1000000; i++) {
            String stringNumber = Integer.toString(i);
            if (isPrime(i)) {
                ArrayList<String> rotations = rotations(stringNumber);
                boolean allPrimes = true;
                for (String rotation : rotations) {
                    int number = Integer.parseInt(rotation);
                    if (!isPrime(number))
                        allPrimes = false;
                }
                if (allPrimes)
                    count++;
            }
        }
        System.out.println(count);
    }
}
