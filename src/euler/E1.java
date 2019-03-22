package euler;

import static math.Functions.sumDivisibleBy;

public class E1 {

    public static void start() {

        int sum = 0;

        for (int i = 1; i < 1000; i++)
            if (i % 3 == 0 || i % 5 == 0)
                sum += i;

        System.out.println(sum);
    }

    public static void startOptimal() {
        System.out.println(sumDivisibleBy(3, 0, 999) + sumDivisibleBy(5, 0, 999) - sumDivisibleBy(15, 0, 999));
    }
}
