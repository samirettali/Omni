package euler;

import java.util.ArrayList;

import static math.Primes.isPrime;

public class E58 {

    public static void start() {
        long d1;
        long d2;
        long d3;
        long size = 0;
        long counter = 0;
        double percentual = 100;

        while (percentual > 0.10) {
            size++;
            d1 = 4 * size * size - 2 * size + 1;
            d2 = 4 * size * size + 1;
            d3 = 4 * size * size + 2 * size + 1;

            if (isPrime(d1))
                counter++;
            if (isPrime(d2))
                counter++;
            if (isPrime(d3))
                counter++;

            // System.out.println(size + " " + d1 + " " + d2 + " " + d3 + " " + d4);
            percentual = (double) counter / (size * 4 + 1);
            // System.out.println(counter + " " + size + " " + percentual);

        }

        System.out.println(size * 2 + 1);

    }

}
