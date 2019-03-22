package math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;

public class Series {
    public static final MathContext PRECISION = new MathContext(4096);

    public static ArrayList<Long> fibonacci(long a, long b, long n) {
        ArrayList<Long> numbers = new ArrayList<Long>();
        numbers.add(a);
        numbers.add(b);
        int size = numbers.size();
        while (size < n) {
            numbers.add(numbers.get(size - 1) + numbers.get(size - 2));
            size = numbers.size();
        }

        return numbers;
    }

    public static String phi(long a, long b, long n) {
        BigInteger x = new BigInteger(Long.toString(a));
        BigInteger y = new BigInteger(Long.toString(b));
        for (int i = 0; i < n; i++) {
            BigInteger temp = x.add(y);
            y = x;
            x = temp;
        }
        return new BigDecimal(x.toString()).divide(new BigDecimal(y.toString()), PRECISION).toString();
    }

    public static ArrayList<String> conwaySeries(long seed, int length) {
        ArrayList<String> series = new ArrayList<>();
        series.add(Long.toString(seed));

        for (int i = 0; i < length; i++) {
            String last = series.get(series.size() - 1);
            String next = "";
            for (int index = 0; index < last.length();) {
                int count = 1;
                int cursor = index;
                while (cursor + 1 < last.length() && last.charAt(cursor) == last.charAt(cursor + 1)) {
                    count++;
                    cursor++;
                }
                next += Integer.toString(count) + last.charAt(cursor);
                index = cursor + 1;
            }
            series.add(next);
        }
        return series;
    }

    public static String conwayConstant(long seed, int iterations) {
        String a = Long.toString(seed);
        String b = null;

        for (int i = 0; i < iterations; i++) {
            String next = "";
            int index = 0;
            while (index < a.length()) {
                int count = 1;
                int cursor = index;
                while (cursor + 1 < a.length() && a.charAt(cursor) == a.charAt(cursor + 1)) {
                    count++;
                    cursor++;
                }
                next += Integer.toString(count) + a.charAt(cursor);
                index = cursor + 1;
            }
            b = a;
            a = next;
        }
        System.out.println(a + " " + b);
        return new BigDecimal(a).divide(new BigDecimal(b), PRECISION).toString();
    }

    public static ArrayList<Long> multiplicativePersistence(long start) {
        ArrayList<Long> list = new ArrayList<>();
        list.add(start);

        long n = start;

        while (n > 9) {
            long product = 1;
            while (n != 0) {
                product *= n % 10;
                n /= 10;
            }
            n = product;
            list.add(product);
        }
        return list;
    }

    public static ArrayList<Long> additivePersistence(long start) {
        ArrayList<Long> list = new ArrayList<>();
        list.add(start);

        long n = start;

        while (n > 9) {
            long sum = 0;
            while (n != 0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
            list.add(sum);
        }
        return list;
    }

    public static long multiplicativePersistence(String start) {
        BigInteger n = new BigInteger(start);
        BigInteger zero = new BigInteger("0");
        BigInteger ten = new BigInteger("10");
        BigInteger nine = new BigInteger("9");

        long count = 0;
        while (n.compareTo(nine) > 0) {
            count++;
            BigInteger product = new BigInteger("1");
            while (!n.equals(zero)) {
                product = product.multiply(n.mod(ten));
                n = n.divide(ten);
            }
            n = product;
        }
        return count;
    }
}
