package euler;

/**
 * Created by Sam on 13/03/2017.
 */
public class E6 {


    public static void start() {
        long limit = 100, sumOfSquares = 0;
        for (int i = 1; i <= limit; i++)
            sumOfSquares += Math.pow(i, 2);
        System.out.println((long) Math.pow(limit * (limit + 1) / 2, 2) - sumOfSquares);
    }

    public static void startOptimized() {
        long limit = 100;
        System.out.println((long) Math.pow(limit * (limit + 1) / 2, 2) - ((2 * limit + 1) * (limit + 1) * limit / 6));
    }
}
