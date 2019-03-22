package files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FileAnalysis {

	public static void countWords(String filename) {

		HashMap<String, Integer> words = new HashMap<String, Integer>();

		try {
			BufferedReader file = new BufferedReader(new FileReader(filename));

			String currentLine;
			String[] currentWords;

			while ((currentLine = file.readLine()) != null) {

				currentWords = currentLine.replace(".", "").replace(",", "").replace(":", "").replace(";", "").replace("'", "").split(" ");

				for (int i = 0; i < currentWords.length; i++) {
					int number = 1;
					if (words.containsKey(currentWords[i]))
						number = words.get(currentWords[i]) + 1;
					words.put(currentWords[i], number);
				}

			}
			// sorting
			words = words.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

			// print
			for (String key : words.keySet())
				System.out.println(key + ": " + words.get(key));

		} catch (FileNotFoundException e) {
		    System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("I/O error");
		}

	}
}
