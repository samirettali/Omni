package euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

import static java.lang.Math.pow;

/**
 * Created by samir on 02/04/17.
 */
public class E29 {

    public static void start() {
        int a, b, limit = 100;
        SortedSet<Double> set = new TreeSet<>();

        for (a = 2; a <= limit; a++)
            for (b = 2; b <= limit; b++)
                set.add(Math.pow(a, b));

        System.out.println(set.size());
    }

    // mathblog
    public static void startOptimized() {
        System.out.println();
    }
}
