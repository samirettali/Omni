package euler;

import java.math.BigInteger;

/**
 * Created by Sam on 30/03/2017.
 */
public class E25 {

    public static void start() {
        BigInteger a = new BigInteger("1"), b = new BigInteger("1"), limit = new BigInteger("10").pow(999);
        int counter = 2;

        while (b.compareTo(limit) <= 0) {
            b = b.add(a);
            a = b.subtract(a);
            counter++;
        }

        System.out.println(counter);
    }
}
