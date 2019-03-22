package euler;

import java.util.ArrayList;
import java.util.HashSet;

import static math.Primes.isPrime;
import static math.Primes.primesUpTo;
import static math.Functions.combinations;

import misc.Stopwatch;

public class E60 {

    public static String concat(long n, long m) {
        return Long.toString(n) + Long.toString(m);
    }

    public static long concatLong(long n, long m) {
        return Long.parseLong(concat(n, m));
    }

    public static HashSet makePairs(int a, ArrayList<Long> primes) {
        HashSet pairs = new HashSet();
        for (int b = a + 1; b < primes.size(); b++) {
            if (isPrime(concatLong(primes.get(a), primes.get(b))) && isPrime(concatLong(primes.get(b), primes.get(a))))
                pairs.add(primes.get(b));
        }

        return pairs;
    }

    public static void start() {

        int nPrimes;
        int[] i = new int[5];

        long sum = 0;
        long limit = 30000;
        long minSum = Long.MAX_VALUE;
        long[] primes = new long[5];

        boolean valid;

        ArrayList<Long> p = primesUpTo(limit);
        p.remove(0);
        ArrayList<ArrayList<Integer>> indexes = combinations(primes.length, 2);

        Stopwatch sw = new Stopwatch();

        nPrimes = p.size();

        // create list of concatenable primes

        HashSet[] concatenables = new HashSet[nPrimes];

        for (int a = 0; a < nPrimes; a++) {
            concatenables[a] = makePairs(a, p);
        }


        for (i[0] = 0; i[0] < nPrimes; i[0]++) {
            primes[0] = p.get(i[0]);
            System.out.println(primes[0]);
            for (i[1] = i[0] + 1; i[1] < nPrimes; i[1]++) {
                primes[1] = p.get(i[1]);
                for (i[2] = i[1] + 1; i[2] < nPrimes; i[2]++) {
                    primes[2] = p.get(i[2]);
                    for (i[3] = i[2] + 1; i[3] < nPrimes; i[3]++) {
                        primes[3] = p.get(i[3]);
                        for (i[4] = i[3] + 1; i[4] < nPrimes; i[4]++) {
                            primes[4] = p.get(i[4]);

                            valid = true;

                            for (ArrayList<Integer> index : indexes) {
                                int k = index.get(0) - 1;
                                int j = index.get(1) - 1;
                                Long n = concatLong(primes[k], primes[j]);
                                Long m = concatLong(primes[j], primes[k]);
                                if (!concatenables[p.indexOf(n)].contains(m) || !concatenables[p.indexOf(m)].contains(n))
                                    valid = false;
                            }

                            if (valid) {

                                sum = 0;
                                System.out.println("VALID FOUND");
                                for (int j = 0; j < primes.length; j++) {
                                    sum += primes[j];
                                    System.out.print(primes[j] + " ");
                                }
                                System.out.println("SUM: " + sum);

                                if (sum < minSum)
                                    minSum = sum;
                            }


                        } // primo for chiuso
                    }
                }
            }
        }
        System.out.println(minSum);
    }
}
