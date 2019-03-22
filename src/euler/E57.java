package euler;

import math.Fraction;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class E57 {

    public static void start() {

        BigInteger n = new BigInteger("3");
        BigInteger d = new BigInteger("2");
        long count = 0;

        for (int i = 0; i < 1000; i++) {
            n = n.add(d.multiply(new BigInteger("2")));
            d = n.subtract(d);

            if (n.toString().length() > d.toString().length())
                count++;
        }

        System.out.println(count);

    }
}