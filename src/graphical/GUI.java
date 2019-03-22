package graphical;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Class used to draw a list of coordinates given as a List.
 */
public class GUI {

	public static void draw(ArrayList<Integer> coordinates, int width, int height, int factor) {
		final Dimension d = new Dimension(width, height);

		JFrame frame = new JFrame();
		frame.setSize(d);
		frame.setResizable(false);
		frame.setVisible(true);

		frame.add(new JPanel() {
			public void paintComponent(Graphics g) {

				super.paintComponent(g);
				int size = coordinates.size();
				setBackground(Color.BLACK);

				Graphics2D g2 = (Graphics2D) g;
				g2.translate(width / 2, height / 2);
				g2.setColor(Color.WHITE);


				if (size % 2 == 0)
					for (int i = 0; i < size; i += 2) {
						g2.fillRect(coordinates.get(i) * factor, coordinates.get(i + 1) * factor, factor, factor);
					}
				else
					for (int i = 0; i < size; i += 3) {
						g2.fillRect(coordinates.get(i) * factor, coordinates.get(i + 1) * factor, coordinates.get(i + 2), coordinates.get(i + 2));
					}

			}
		});

	}
}
