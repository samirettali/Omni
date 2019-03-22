package util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Samir Ettali
 **/
public class Array {
    public static Long sum(Long[] array) {
        Long result = 0l;
        for (int i = 0; i < array.length; i++)
            result += array[i];
        return result;
    }

    public static BigInteger sum(BigInteger[] array) {
        BigInteger result = new BigInteger("0");
        for (int i = 0; i < array.length; i++)
            result = result.add(array[i]);
        return result;
    }

    public static Long sum(ArrayList<Long> array) {
        Long result = 0l;
        for (Long n : array)
            result += n;
        return result;
    }

    public static long digitsSum(BigInteger number) {
        String n = number.toString();
        long sum = 0;
        long length = n.length();
        for (int i = 0; i < length; i++)
            sum += n.charAt(i) - '0';
        return sum;
    }

    public static int[] randomPositiveIntArray(int length, int limit) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++)
            array[i] = random.nextInt(limit);
        return array;
    }
}
