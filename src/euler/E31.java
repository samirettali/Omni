package euler;

public class E31 {

    public static void start() {
        int target = 200;
        long count = 0;

        for (int a = target; a >= 0; a -= 200)
            for (int b = a; b >= 0; b -= 100)
                for (int c = b; c >= 0; c -= 50)
                    for (int d = c; d >= 0; d -= 20)
                        for (int e = d; e >= 0; e -= 10)
                            for (int f = e; f >= 0; f -= 5)
                                for (int g = f; g >= 0; g -= 2)
                                        count++;
        System.out.println(count);
    }


    public static void startOptimized() {
        int amount = 200;
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        long[] ways = new long[amount + 1];

        ways[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++)
                ways[j] += ways[j - coins[i]];
        }

        System.out.println(ways[amount]);
    }
}
