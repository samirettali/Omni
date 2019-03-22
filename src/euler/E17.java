package euler;

import java.util.HashMap;

public class E17 {

    public static void start() {
        int oneToNine = 3 + 3 + 5 + 4 + 4 + 3 + 5 + 5 + 4;
        int tenToNineteen = 3 + 6 + 6 + 8 + 8 + 7 + 7 + 9 + 8 + 8;
        int twentyToNinetynine = 10 * (6 + 6 + 5 + 5 + 5 + 7 + 6 + 6) + 8 * 36;
        int onehundredToNinehundredninetynine = 3600 + 7686 + 63 + 8910;

        System.out.println(oneToNine + tenToNineteen + twentyToNinetynine + onehundredToNinehundredninetynine + 11);
    }
}
