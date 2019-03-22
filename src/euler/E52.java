package euler;


import static misc.Strings.isPalindrome;

public class E52 {

    public static void start() {

        int t1 = 1;
        int t2;
        int t3;
        int t4;
        int t5;
        int t6;

        boolean found = false;

        do {
            t2 = t1 * 2;
            t3 = t1 * 3;
            t4 = t1 * 4;
            t5 = t1 * 5;
            t6 = t1 * 6;

            if (isPalindrome(Integer.toString(t1), Integer.toString(t2), Integer.toString(t3), Integer.toString(t4), Integer.toString(t5), Integer.toString(t6)))
                found = true;
            else
                t1++;
        } while (!found);

        System.out.println(t1);


    }

}
