package euler;

import java.util.ArrayList;

import static math.Properties.isAbundant;
import static util.Array.sum;

public class E23 {

    public static void start() {
        final int limit = 28123;

        ArrayList<Long> numbers = new ArrayList<>();
        ArrayList<Long> abundants = new ArrayList<>();
        int size;

        for (long i = 1; i <= limit; i++) {
            numbers.add(i);
            if (isAbundant(i))
                abundants.add(i);
        }

        while (abundants.size() > 0) {
            Long n = abundants.get(0);

            for (Long m : abundants) {
                if (numbers.contains(n + m))
                    numbers.remove(n + m);
                if (n + m > limit)
                    break;
            }

            abundants.remove(0);
        }

        System.out.println(sum(numbers));
    }

    public static void startOptimized() {
        final int limit = 28123;

        ArrayList<Long> numbers = new ArrayList<>();
        ArrayList<Long> abundants = new ArrayList<>();
        boolean[] abundantsSum = null;
        long sum = 0;

        for (long i = 1; i <= limit; i++) {
            numbers.add(i);
            if (isAbundant(i))
                abundants.add(i);
        }

        abundantsSum = new boolean[limit * 2 + 1];

        for (int i = 0; i < abundants.size(); i++) {
            for (int j = 0; j <= i; j++) {
                abundantsSum[(int) (abundants.get(i) + abundants.get(j))] = true;
            }
        }

        for (int i = 0; i < limit; i++) {
            if (!abundantsSum[i])
                sum += i;
        }

        System.out.println(sum);
    }
}
