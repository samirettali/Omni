package euler;

import static math.Properties.isHexagonal;
import static math.Properties.isPentagonal;
import static math.Properties.isTriangular;

public class E45 {

    public static void start() {
        int n = 40755;
        do {
            n++;
        } while (!isTriangular(n) || !isPentagonal(n) || !isHexagonal(n));

        System.out.println(n);
    }

    public static void start2() {
        long n = 0;
        int i = 143;

        do {
            i++;
            n = i * (2 * i - 1);

        } while (!isPentagonal(n));

        System.out.println(n);
    }
}
