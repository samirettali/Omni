package euler;

import java.util.ArrayList;
import java.util.HashSet;

import static math.Factors.getFactors;
import static math.Factors.getPrimeFactors;
import static math.Properties.nthTriangle;

public class E12 {

    public static void start() {
        long sum, i = 0, max = 0, n;
        int divisors;

        do {
            i++;
            sum = nthTriangle(i);
            divisors = getFactors(sum).size();
        } while (divisors <= 500);

        System.out.println(sum);
    }

    public static void startOptimized() {

        ArrayList<Long> factors;

        long n = 0, x = 0, size;

        while (n <= 500) {
            x++;
            factors = getPrimeFactors(x);
            size = factors.size();
            n = 1;
            for (int i = 0; i < size; i++) {

            }
        }
    }
}
