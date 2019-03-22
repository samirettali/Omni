package graphical; /**
 * Created by Sam on 15/03/2017.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static math.Primes.isPrime;


public class UlamComplete {

	public static void draw(int width, int height, int factor) {

		GUI.draw(getCoordinates(width, height, factor), width, height, factor);

	}

	private static ArrayList<Integer> getCoordinates(int width, int heigth, int factor) {
		ArrayList<Integer> coordinates = new ArrayList<Integer>();

		int row = 0;
		int col = 0;

		long steps = 1;
		int counter = 1;

		while (steps < width / factor) {
			for (int i = 0; i < steps; i++) {
				col++;
				counter++;
				coordinates.add(col);
				coordinates.add(row);
				coordinates.add((int) math.Factors.getFactorsNumber(counter));
			}

			for (int i = 0; i < steps; i++) {
				row--;
				counter++;
				coordinates.add(col);
				coordinates.add(row);
				coordinates.add((int) math.Factors.getFactorsNumber(counter));

			}

			steps++;

			for (int i = 0; i < steps; i++) {
				col--;
				counter++;
				coordinates.add(col);
				coordinates.add(row);
				coordinates.add((int) math.Factors.getFactorsNumber(counter));

			}

			for (int i = 0; i < steps; i++) {
				row++;
				counter++;
				coordinates.add(col);
				coordinates.add(row);
				coordinates.add((int) math.Factors.getFactorsNumber(counter));

			}

			steps++;

		}
		System.out.println(steps);
		return coordinates;
	}


}
