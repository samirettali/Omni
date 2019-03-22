package euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Arrays;

public class E54 {

    public static int countOccurences(int[] array, int value) {
        int count = 0;

        for (int i = 0; i < array.length; i++)
            if (array[i] == value)
                count++;

        return count;
    }

    public static int[] evaluatePokerHand(String hand) {

        char value;
        int intValue = 0;
        int firstCouple = 0;
        int[] values = new int[5];
        char[] suits = new char[5];
        int[] sortedValues;
        int[] result = new int[3];

        for (int i = 0; i < 5; i++) {

            value = hand.replaceAll(" ", "").charAt(i * 2);

            if (value >= '2' && value <= '9')
                intValue = value - '0';

            else if (value == 'T')
                intValue = 10;
            else if (value == 'J')
                intValue = 11;
            else if (value == 'Q')
                intValue = 12;
            else if (value == 'K')
                intValue = 13;
            else if (value == 'A')
                intValue = 14;

            values[i] = intValue;
            suits[i] = hand.replaceAll(" ", "").charAt(i * 2 + 1);
        }

        sortedValues = values;

        Arrays.sort(sortedValues);

        boolean flush = true;
        boolean straight = true;
        boolean poker = false;
        boolean tris = false;
        boolean doublePair = false;
        boolean pair = false;

        for (int i = 0; i < suits.length - 1; i++) {

            if (suits[i] != suits[i + 1])
                flush = false;

            if (sortedValues[i] + 1 != sortedValues[i + 1])
                straight = false;

            if (countOccurences(values, values[i]) == 4) {
                poker = true;
                result[1] = values[i];
            } else if (countOccurences(values, values[i]) == 3) {
                tris = true;
                result[1] = values[i];
            } else if (countOccurences(values, values[i]) == 2) {
                if (!pair) {
                    pair = true;
                    firstCouple = values[i];
                    result[1] = values[i];
                } else {
                    if (values[i] != firstCouple) {
                        doublePair = true;
                        result[2] = values[i];
                    }
                }
            }
        }

        if (straight && flush) {
            result[0] = 10;
            result[1] = sortedValues[4];
        } else if (poker) {
            result[0] = 9;
        } else if (tris && pair) {
            result[0] = 8;
        } else if (flush)
            result[0] = 7;

        else if (straight)
            result[0] = 6;

        else if (tris)
            result[0] = 5;

        else if (doublePair)
            result[0] = 4;

        else if (pair) {
            result[0] = 3;
        } else {
            result[0] = 2;
            result[1] = sortedValues[4];
        }

        return result;

    }

    public static int compareHands(int[] first, int[] second) {

        if (first[0] > second[0])
            return 1;

        if (first[0] < second[0])
            return 2;

        if (first[0] == second[0]) {
            if (first[0] == 4) {
                if (first[1] > second[1])
                    return 1;
                else if (first[1] < second[1])
                    return 2;
                else if (first[2] > second[2])
                    return 1;
                else if (first[2] < second[2])
                    return 2;
                else return 0;
            } else if (first[1] > second[1])
                return 1;
            else if (first[1] < second[1])
                return 2;
            else
                return 0;
        }

        return -1;

    }

    public static void start() {
        try {

            String line;
            String first;
            String second;
            int count = 0;

            FileReader fr = new FileReader("/run/media/samir/Passport/Sviluppo/Java/Libreria/src/euler/p054_poker.txt");
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                first = line.substring(0, 14);
                second = line.substring(15, 29);
                if (compareHands(evaluatePokerHand(first), evaluatePokerHand(second)) == 1)
                    count++;
            }

            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
