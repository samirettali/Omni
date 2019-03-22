package euler;

import static math.Properties.getAmicable;

/**
 * Created by Sam on 27/03/2017.
 */
public class E21 {

    public static void start() {
        int limit = 10000, sum = 0, friend;

        for (int i = 2; i < limit; i++) {
            friend = (int) getAmicable(i);
            if (friend != -1)
                sum += i;
        }
        System.out.println(sum);
    }
}
