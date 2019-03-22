package euler;

/**
 * Created by Sam on 14/03/2017.
 */
public class E14 {

    public static void start() {
        int max = 0, n = 0, size;
        for (int i = 1; i < 1000000; i++) {
            size = math.Functions.collatzSequence(i).size();
            if (size > max) {
                max = size;
                n = i;
            }


        }

        System.out.println(n);
    }

}
