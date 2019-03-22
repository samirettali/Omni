package euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

import static math.Primes.isPrime;
import static math.Properties.isPandigitalNoZero;
import static misc.Strings.permutations;

public class E41 {

    public static void start() {
        String n = null;
        int len = 9;
        ArrayList<String> permutations;
        boolean found = false;

        do {
            String sequence = "";
            for (int i = 1; i <= len; i++)
                sequence += i;
            permutations = permutations(sequence);
            Collections.sort(permutations, new Comparator<String>() {
                public int compare(String s1, String s2) {
                    return s2.compareTo(s1);
                }
            });
            System.out.println(len + " " + permutations.size());
            len--;
            while (permutations.size() > 0 && !found) {
                n = permutations.remove(0);
                if (isPandigitalNoZero(n, 10) && isPrime(Long.parseLong(n)))
                    found = true;
            }
        } while (!found && len > 0);

        System.out.println(n);
    }

}
