package euler;

import java.math.BigInteger;

public class E48 {

    public static void start() {
        BigInteger result = new BigInteger("0");

        for (int i = 1; i <= 1000; i++)
            result = result.add(new BigInteger(Integer.toString(i)).pow(i));

        System.out.println(result.toString().substring(result.toString().length() - 10, result.toString().length()));

    }
}
