package euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class E42 {

    public static int nthTriangle(int n) {
        return (int) (0.5 * n * (n + 1));
    }

    public static void start() {
        FileReader fr;
        BufferedReader br;
        int maxScore = 0;
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Integer> scores = new ArrayList<Integer>();
        ArrayList<Integer> triangleNumbers = new ArrayList<Integer>();

        try {
            fr = new FileReader("/run/media/samir/Passport/Sviluppo/Java/Libreria/src/euler/p042_words.txt");
            br = new BufferedReader(fr);

            words = new ArrayList<>(Arrays.asList(br.readLine().replace("\"", "").split(",")));
            for (String word : words) {
                int score = 0;
                for (int i = 0; i < word.length(); i++)
                    score += word.charAt(i) - 'A' + 1;
                if (score > maxScore)
                    maxScore = score;
                scores.add(score);
            }
            System.out.println(maxScore);
            int triangle;
            int i = 1;
            while ((triangle = nthTriangle(i)) < maxScore) {
                triangleNumbers.add(triangle);
                i++;
            }
            int count = 0;
            for (int score : scores)
                if (triangleNumbers.contains(score))
                    count++;
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
