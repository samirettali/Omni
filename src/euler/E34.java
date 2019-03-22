package euler;

import static math.Functions.factorial;

/**
 * @author Samir Ettali
 **/
public class E34 {
    public static void start() {
        long result = 0;
        for (int i = 10; i < 40586; i++) {
            int number = i;
            long digitsSum = 0;
            while (number > 0) {
                digitsSum += factorial(number % 10);
                number /= 10;
            }
            if (digitsSum == i)
                result += digitsSum;
        }
        System.out.println(result);
    }
}
