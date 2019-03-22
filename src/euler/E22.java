package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class E22 {

    public static void start() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/euler/p022_names.txt"));
            String line = br.readLine(), name;
            line = line.replace("\"", "");
            ArrayList<String> names = new ArrayList<String>(Arrays.asList(line.split(",")));
            Collections.sort(names);
            int size = names.size(), i, j, len, score, total = 0;
            for (i = 0; i < size; i++) {
                name = names.get(i);
                len = name.length();
                score = 0;
                for (j = 0; j < len; j++)
                    score += name.charAt(j) - 'A' + 1;
                total += score * (i + 1);
            }
            System.out.println(total);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
