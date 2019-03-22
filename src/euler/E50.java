package euler;

import java.util.ArrayList;

import static math.Primes.eratosteneList;
import static math.Primes.isPrime;

public class E50 {

    public static void start() {

        int sum;
        int maxPrime = 0;
        int consecutivePrimes;
        int maxConsecutivePrimes = 0;

        ArrayList<Integer> primes = eratosteneList(1000000);
        for (int i = primes.size() - 1; i > 0; i--) {
            sum = 0;
            consecutivePrimes = 0;
            for (int j = i; j > 0 && sum < 1000000; j--) {
                sum += primes.get(j);
                consecutivePrimes++;
                if (isPrime(sum) && consecutivePrimes > maxConsecutivePrimes && sum < 1000000) {
                    maxConsecutivePrimes = consecutivePrimes;
                    maxPrime = sum;
                }
            }
        }

        System.out.println(maxPrime);
    }
}