package graphical;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static math.Primes.isPrime;

public class Sacks {

	public static void draw(int width, int height, int factor) {
		GUI.draw(getCoordinates(width, height, factor), width, height, factor);
	}

	private static ArrayList<Integer> getCoordinates(int width, int height, int factor) {
		ArrayList<Integer> coordinates = new ArrayList<Integer>();

		double r = 0, t = 0;
		int counter = 1, x = 0;
		while (x + 50 < height / (factor * 2)) {
			if (isPrime(counter)) {
				r = Math.sqrt(counter);
				t = r * 2 * 3.14159;
				x = (int) (r * Math.cos(t));
				coordinates.add(x);
				coordinates.add((int) (r * Math.sin(t)));
			}
			counter++;
		}

		return coordinates;

	}

}
