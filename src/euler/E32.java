package euler;

import java.util.ArrayList;

import static math.Properties.isPandigital;

public class E32 {

    public static void start() {
        ArrayList<Integer> nums = new ArrayList<>();
        int product, sum = 0;
        String s;

        int limit = (int) Math.sqrt(1000000000);
        for (int i = 2; i < limit; i++) {
            for (int j = 1; j * i < limit; j++) {
                product = i * j;
                s = Integer.toString(i) + Integer.toString(j) + Integer.toString(product);
                s = s.replaceAll(" ", "");
                if (s.length() == 9 && pandi(Long.parseLong(s)) && !nums.contains(product)) {
                    sum += product;
                    nums.add(product);
                }
            }
        }
        System.out.println(sum);
    }

    public static void startOptimized() {
        ArrayList<Integer> products = new ArrayList<Integer>();
        int sum = 0, prod, compiled;

        for (int m = 2; m < 100; m++) {
            int nbegin = (m > 9) ? 123 : 1234;
            int nend = 10000 / m + 1;

            for (int n = nbegin; n < nend; n++) {
                prod = m * n;
                compiled = concat(concat(prod, n), m);
                if (compiled >= 1E8 && compiled < 1E9 && pandi(compiled)) {
                    if (!products.contains(prod)) {
                        products.add(prod);
                    }
                }
            }
        }

        for (int i = 0; i < products.size(); i++) {
            sum += products.get(i);
        }

        System.out.println(sum);
    }

    private static int concat(int a, int b) {

        int c = b;
        while (c > 0) {
            a *= 10;
            c /= 10;
        }

        return a + b;
    }

    private static boolean pandi(long n) {
        int digits = 0;
        int count = 0;
        int tmp;

        while (n > 0) {
            tmp = digits;
            digits = digits | 1 << (int) ((n % 10) - 1); //The minus one is there to make 1 fill the first bit and so on
            if (tmp == digits) { //Check to see if the same digit is found multiple times
                return false;
            }

            count++;
            n /= 10;
        }

        return digits == (1 << count) - 1;
    }
}
