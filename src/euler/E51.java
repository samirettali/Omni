package euler;

import java.util.ArrayList;

import static math.Primes.isPrime;
import static misc.Strings.permutations;

public class E51 {

    public static void start() {

        String m;
        String k;
        long n = 1;
        long nStars = 1;
        long probablePrime;

        ArrayList<String> permutations;
        ArrayList<Long> primes = new ArrayList<>();

        do {
            String stars = "";

            if (nStars == 6) {
                nStars = 0;
                n++;
            }

            for (int i = 0; i < nStars; i++)
                stars += "*";

            permutations = permutations(Long.toString(n) + stars);
            ArrayList<String> singlePermutations = new ArrayList<>();

            for (String permutation : permutations)
                if (!singlePermutations.contains(permutation))
                    singlePermutations.add(permutation);

            permutations = singlePermutations;

            for (String permutation : permutations) {
                primes = new ArrayList<>();
                for (int i = 1; i < 10; i++) {
                    probablePrime = Long.parseLong(permutation.replaceAll("\\*", Integer.toString(i)));
                    if (isPrime(probablePrime)) {
                        primes.add(probablePrime);
                    }
                }
            }

            nStars++;
        } while (primes.size() != 8);

        if (primes.size() == 8)
            System.out.println(primes);


    }
}
