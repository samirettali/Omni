package euler;

import java.math.BigInteger;

public class E56 {

    public static void start() {
        String s;
        long sum;
        long max = 0;
        BigInteger n;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {

                n = new BigInteger(Integer.toString(i)).pow(j);
                s = n.toString();
                sum = 0;


                for (int k = 0; k < s.length(); k++)
                    sum += s.charAt(k) - '0';

                if (sum > max)
                    max = sum;
            }
        }
        System.out.println(max);

    }
}
