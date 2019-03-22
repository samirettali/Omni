package euler;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Sam on 30/03/2017.
 */
public class E26 {

    public static String getPeriod(int divisor) {
        ArrayList<Integer> rem = new ArrayList<Integer>();
        ArrayList<Integer> decimals = new ArrayList<Integer>();
        String p = "0";

        int x = 1, remainder = 1, i = 0;

        boolean cont = true;
        while (remainder * 10 < divisor)
            remainder *= 10;
        do {
            x = remainder * 10;
            remainder = x % divisor;
            decimals.add(x / divisor);

            if (rem.contains(remainder)) {
                cont = false;
                i = rem.indexOf(remainder) + 1;
            } else {
                rem.add(remainder);
            }

        } while (cont);

        if (decimals.get(decimals.size() - 1) != 0) {
            p = "";
            for (; i < decimals.size(); i++)
                p += Integer.toString(decimals.get(i));
        }

        return p;
    }


    public static void start() {
        int len = 0, max = 0;
        String period;
        for (int i = 2; i <= 1000; i++) {
            period = getPeriod(i);
            if (!period.equals("0") && period.length() > len) {
                len = period.length();
                max = i;

            }
        }
        System.out.println(max);
    }

    public static void startOptimized() {
        int sequenceLength = 0, i;

        for (i = 1000; i > 1; i--) {
            if (sequenceLength >= i) {
                break;
            }

            int[] foundRemainders = new int[i];
            int value = 1;
            int position = 0;

            while (foundRemainders[value] == 0 && value != 0) {
                foundRemainders[value] = position;
                value *= 10;
                value %= i;
                position++;
            }

            if (position - foundRemainders[value] > sequenceLength) {
                sequenceLength = position - foundRemainders[value];
            }
        }
        System.out.println(i + 1);
    }

}
