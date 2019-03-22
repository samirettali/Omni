package euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class E59 {

    public static void start() {

        try {

            FileReader fr = new FileReader("/run/media/samir/Passport/Sviluppo/Java/Libreria/src/euler/p059_cipher.txt");
            BufferedReader br = new BufferedReader(fr);

            String[] cipher = br.readLine().split(",");
            char currentChar;
            long asciiCount = 0;
            long maxAsciiCount = 0;
            long sum = 0;
            long maxSum = 0;
            char[] key = new char[3];

            for (int i = 'a'; i <= 'z'; i++) {
                key[0] = (char) i;
                for (int j = 'a'; j <= 'z'; j++) {
                    key[1] = (char) j;
                    for (int k = 'a'; k <= 'z'; k++) {

                        key[2] = (char) k;

                        asciiCount = 0;
                        sum = 0;

                        for (int l = 0; l < cipher.length; l++) {
                            currentChar = (char) (Integer.parseInt(cipher[l]) ^ key[l % 3]);
                            sum += currentChar;
                            if (currentChar >= 'a' && currentChar <= 'z')
                                asciiCount++;
                        }

                        if (asciiCount > maxAsciiCount) {
                            maxAsciiCount = asciiCount;
                            maxSum = sum;
                        }
                    }
                }
            }
            System.out.println(maxSum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
