package euler;

import java.util.ArrayList;

import static math.Properties.isPentagonal;

public class E44 {

    public static void start() {

        int n;
        int m;
        int i = 1;
        int k = 2;
        int min = Integer.MAX_VALUE;

        m = k * (3 * k - 1) / 2;

        do {
            n = i * (3 * i - 1) / 2;
            i++;

            if (isPentagonal(n + m) && isPentagonal(Math.abs(n - m)))
                min = Math.abs(n - m);

            if (i == k) {
                k++;
                i = 1;
                m = k * (3 * k - 1) / 2;
                ;
            }

        } while (min == Integer.MAX_VALUE);

        System.out.println(min);

    }
}
