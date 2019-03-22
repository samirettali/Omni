package euler;

public class E2 {

    public static void start() {
        int n1 = 1, n2 = 2, sum = 0;

        while (n2 <= 4000000) {
            if (n2 % 2 == 0)
                sum += n2;
            n2 += n1;
            n1 = n2 - n1;
        }

        System.out.println(sum);
    }

    public static void startOptimal() {
        int n1 = 1, n2 = 2, n3 = n1 + n2, sum = 0;

        while (n3 <= 4000000) {
            sum += n3;
            n1 = n2 + n3;
            n2 = n3 + n1;
            n3 = n1 + n2;
        }

        System.out.println(sum);
    }


}
