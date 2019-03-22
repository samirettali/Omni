import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Sam on 28/03/2017.
 */
public class Tris extends JPanel {
    private int size, line;
    private int[][] board;
    private boolean turn;

    private JFrame frame;

    public Tris() {
        size = 600;
        line = 20;

        frame = new JFrame("Tris");
        frame.add(this);

        frame.setSize(size, size);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        setBackground(Color.DARK_GRAY);

        reset();
        loop();
    }

    private void reset() {

        board = new int[][]{{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};
        //drawGrid();
        turn = true;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int x = e.getX(), y = e.getY();
                if (turn)
                    board[x / (size / 3)][y / (size / 3)] = 1;
                else
                    board[x / (size / 3)][y / (size / 3)] = 0;

                turn = !turn;

            }
        });

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        try {
            BufferedImage image = ImageIO.read(new File("cross.png"));

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.BLACK);

            g2.fillRect(size / 3, 0, line, size);
            g2.fillRect(size / 3 * 2, 0, line, size);
            g2.fillRect(0, size / 3, size, line);
            g2.fillRect(0, size / 3 * 2, size, line);

            int dim = size / 4, x, y;

            g2.setStroke(new BasicStroke(10));
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    x = i * (size / 3) + ((size / 3) - dim) / 2;
                    y = j * (size / 3) + ((size / 3) - dim) / 2;
                    if (board[i][j] == 1) {
                        g2.drawImage(image, x, y, dim, dim, null);
                    } else if (board[i][j] == 0) {
                        g2.drawOval(x, y, dim, dim);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loop() {
        while (true) {
            try {
                repaint();
                if (checkWin()) {
                    Thread.sleep(3000);
                    reset();
                }
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != -1 && board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return true;
            if (board[0][i] != -1 && board[0][i] == board[1][i] && board[1][i] == board[2][i])
                return true;
        }

        if (board[0][0] != -1 && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return true;

        if (board[0][2] != -1 && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return true;

        return false;
    }

}
