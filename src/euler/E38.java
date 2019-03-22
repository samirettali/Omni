package euler;

import static math.Properties.isPandigital;
import static misc.Strings.concatLong;

public class E38 {

    public static void start() {
        long max = 0;
        for (long i = 1; i < 10000; i++) {
            System.out.println("Start " + i);
            for (long j = 2; j < 10; j++) {
                long sum = i;
                for (long k = 2; k <= j; k++) {
                    sum = concatLong(sum, i * k);
                }
                if (Long.toString(sum).length() == 9 && isPandigital("0"+ Long.toString(sum), 10) && sum > max)
                    max = sum;
            }

        }
        System.out.println(max);
    }
}

