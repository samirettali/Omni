package euler;

/**
 * Created by samir on 02/04/17.
 */
public class E30 {

    public static void start() {
        StringBuilder number;
        Integer sum, totalSum = 0;

        int[] n = {0, 0, 0, 0, 0, 0};
        int index = n.length - 1, i;

        while (index > 0 && n[0] < 9) {
            number = new StringBuilder();

            sum = 0;
            for (i = 0; i < n.length; i++) {
                number.append(n[i]);
                sum += (int) Math.pow(n[i], 5);

            }

            while (number.length() > 1 && number.charAt(0) == '0')
                number.deleteCharAt(0);

            if (number.toString().equals(sum.toString()))
                totalSum += sum;

            n[index]++;
            for (i = n.length - 1; i > 0; i--) {
                if (n[i] == 10) {
                    n[i] = 0;
                    n[i - 1]++;
                }


            }


        }
        System.out.println(totalSum - 1);
    }



    /*for(n1 = 0; n1 < 10; n1++)
            for(n2 = 0; n2 < 10; n2++)
            for(n3 = 0; n3 < 10; n3++)
            for(n4 = 0; n4 < 10; n4++)
            for(n5 = 0; n5 < 10; n5++)
            for(n6 = 0; n6 < 10; n6++){*/

}
