package euler;

import java.math.BigInteger;

import static math.Functions.bigBinomial;

public class E53 {

    public static void start() {
        int count = 0;
        BigInteger oneMillion = new BigInteger("1000000");

        for (int i = 1; i <= 100; i++) {
            for (int j = 0; j <= i; j++) {
                if (bigBinomial(i, j).compareTo(oneMillion) == 1)
                    count++;
            }
        }

        System.out.println(count);
    }
}
