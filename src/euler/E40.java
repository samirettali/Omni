package euler;

public class E40 {

    public static void start() {
        int result = 1;
        int length = 0;
        int position = 1;
        int index;
        long i = 1;

        while (length <= 1000000) {
            length += Long.toString(i).length();
            if (length >= position) {
                //System.out.println(length + " " + position + " " + i);
                index = Long.toString(i).length() - (length - position) - 1;
                result *= Long.toString(i).charAt(index) - '0';
                position *= 10;
            }
            i++;
        }

        System.out.println(result);
    }
}
