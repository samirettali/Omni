package graphical; /**
 * Created by Sam on 15/03/2017.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static math.Primes.isPrime;


public class Ulam {

	public static void draw(int width, int height, int factor) {
		GUI.draw(getCoordinates(width, height, factor), width, height, factor);
	}

	private static ArrayList<Integer> getCoordinates(int width, int heigth, int factor) {
		ArrayList<Integer> coordinates = new ArrayList<>();

		int row = 0, col = 0, counter = 1;

		long steps = 1;

		while (steps < width / factor) {
			for (int i = 0; i < steps; i++) {
				col++;
				counter++;
				if (isPrime(counter)) {
					coordinates.add(col);
					coordinates.add(row);
				}
			}

			for (int i = 0; i < steps; i++) {
				row--;
				counter++;
				if (isPrime(counter)) {
					coordinates.add(col);
					coordinates.add(row);
				}
			}

			steps++;

			for (int i = 0; i < steps; i++) {
				col--;
				counter++;
				if (isPrime(counter)) {
					coordinates.add(col);
					coordinates.add(row);
				}
			}

			for (int i = 0; i < steps; i++) {
				row++;
				counter++;
				if (isPrime(counter)) {
					coordinates.add(col);
					coordinates.add(row);
				}
			}

			steps++;
			System.out.println(steps);
		}

		return coordinates;
	}


}
