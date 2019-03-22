package ciphers;
import java.util.HashMap;

public class Analysis {
    // TODO implement
    public static HashMap<Character, Integer> frequencyAnalysis(String text) {
        HashMap<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (frequencies.containsKey(c))
                frequencies.put(c, frequencies.get(c) + 1);
            else
                frequencies.put(c, 1);
        }
        return frequencies;
    }
}
