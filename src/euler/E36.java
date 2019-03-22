package euler;

import static math.Functions.decToBin;
import static misc.Strings.isPalindrome;

/**
 * @author Samir Ettali
 **/
public class E36 {
    public static void start() {
        long sum = 0;
        for (int i = 0; i < 1000000; i++) {
            if (isPalindrome(Integer.toString(i)) && isPalindrome(decToBin(i)))
                sum += i;
        }
        System.out.println(sum);
    }
}
