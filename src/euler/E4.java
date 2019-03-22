package euler;

import static misc.Strings.isPalindrome;

public class E4 {

    public static void start() {
        int max = 0, product, i = 999, j;

        while (i > 99) {
            j = 999;
            while (j > 99) {
                product = i * j;
                if (isPalindrome(Integer.toString(product)) && product > max)
                    max = product;
                j--;

            }
            i--;
        }

        System.out.println(max);
    }

    public static void startOptimized() {
        int max = 0, product, i = 999, j, db;

        while (i > 99) {
            if (i % 11 == 0) {
                j = 999;
                db = 1;
            } else {
                j = 990;
                db = 11;
            }
            while (j >= i) {
                product = i * j;
                if (product <= max)
                    break;

                if (isPalindrome(Integer.toString(product)))
                    max = product;
                j -= db;

            }
            i--;
        }

        System.out.println(max);
    }
}
