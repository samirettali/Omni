package euler;

import static math.Properties.isLyachel;

public class E55 {

    public static void start() {
        int count = 0;

        for (int i = 0; i < 10000; i++)
            if (isLyachel(i))
                count++;

        System.out.println(count);
    }
}
