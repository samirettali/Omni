package misc;

import java.util.ArrayList;

import static math.Functions.smallestPowerOfTwo;

/**
 * Created by Sam on 22/03/2017.
 */
public class Josephus {


    // formula: n = 2^x + l
    // return 2l + 1
    // or in binary notation 101001 -> 10011 (move the first digit to the last position)
    public static long start(long n) {

        assert n > 0;

        ArrayList<Long> people = new ArrayList<Long>();
        int counter = 1;

        for (long i = 0; i < n; i++)
            people.add(i + 1);

        while (people.size() > 1) {
            people.remove(counter);
            counter++;
            if (counter >= people.size())
                counter = counter % people.size();
        }

        return people.get(0);
    }

    public static long optimal(long n) {
        assert n > 0;
        return (n - smallestPowerOfTwo(n)) * 2 + 1;
    }
}
