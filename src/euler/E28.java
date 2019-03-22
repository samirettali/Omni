package euler;

import static util.Array.print;

/**
 * Created by samir on 02/04/17.
 */
public class E28 {

    public static int[][] getSpiral(int dim) {
        int x = dim / 2, y = dim / 2, steps = 1, n = 2;
        int[][] spiral = new int[dim][dim];
        spiral[y][x] = 1;

        while (steps < dim && x >= 0 && x < dim && y >= 0 && y < dim) {

            for (int i = 0; i < steps && x + 1 < dim; i++) {
                x++;
                spiral[y][x] = n;
                n++;
            }

            for (int i = 0; i < steps && y + 1 < dim; i++) {
                y++;
                spiral[y][x] = n;
                n++;
            }

            steps++;

            for (int i = 0; i < steps && x > 0; i++) {
                x--;
                spiral[y][x] = n;
                n++;
            }


            for (int i = 0; i < steps && y > 0; i++) {
                y--;
                spiral[y][x] = n;
                n++;
            }

            steps++;
        }
        for (int i = 0; i < steps && x + 1 < dim; i++) {
            x++;
            spiral[y][x] = n;
            n++;
        }

        return spiral;
    }

    public static void start() {
        int dim = 1001, sum = 0;
        int[][] spiral = getSpiral(dim);

        for (int i = 0; i < dim; i++)
            sum += spiral[i][i] + spiral[i][dim - i - 1];


        System.out.println(sum - 1);
    }

    // mathblog
    public static void startOptimized() {
        System.out.println(16 / 3 * (int) Math.pow(500, 3) + 10 * (int) Math.pow(500, 2) + 26 / 3 * 500 + 1);
    }
}
