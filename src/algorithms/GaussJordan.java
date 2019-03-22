package algorithms;

import structure.Matrix;

public class GaussJordan {

    /* private Matrix mx;
    private Matrix res;
    private int rows, cols;

    public GaussJordan(double[][] mx, double[][] res) {
        this.mx.set(mx);
        this.res.set(res);
        rows = this.mx.getRows();
        cols = this.mx.getCols();
    }

    //funzione che scambia due righe della matrice
    private void swap(int a, int b) {
        double[] temp = mx.getRowAsArray(a);
        mx.setRow(a, mx.getRowAsArray(b));
        mx.setRow(b, temp);

        temp = res.getRowAsArray(a);
        res.setRow(a, res.getRowAsArray(b));
        res.setRow(b, temp);
        System.out.println("SWAP M" + (a + 1) + " M" + (b + 1));
        printMatrix();
    }

    //funzione che calcola il lambda per due numeri
    private double getLambda(double[] v, double[] u, int x) {
        return v[x] / u[x];
    }

    private boolean solveAgain() {
        int zeroCount;
        for (int i = 0; i < rows; i++) {
            zeroCount = 1;
            for (int j = 0; j < cols; j++) {
                if (mx.getRowAsArray(i)[j] == 0)
                    zeroCount++;
            }
            if (zeroCount < rows)
                return true;
        }
        return false;
    }

    //funzione che stampa la matrice dei coefficienti e i risultati
    private void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(mx.getRowAsArray(i)[j] + "\t");
            }
            System.out.print(res.getRowAsArray(i)[0]);
            System.out.println();
        }
        System.out.println("\n");
    }

    private void operation(int a, int b, double lambda) {
        mx.getRowAsVector(b).mult(lambda);
        res.getRowAsVector(b).mult(lambda);
        mx.getRowAsVector(a).sub(mx.getRowAsVector(b));
        res.getRowAsVector(a).sub(res.getRowAsVector(b));
        mx.setRow(a, mx.getRowAsVector(a));
        res.setRow(a, res.getRowAsVector(a));
        System.out.println("M" + (a + 1) + " M" + (b + 1) + "*" + lambda);
        printMatrix();
    }

    private boolean checkZeros(int a, int b, int limit) {

        //Controllo che per ogni zero nella riga A ce ne sia uno in B
        double[] rowA = mx.getRowAsArray(a);
        double[] rowB = mx.getRowAsArray(b);

        //restituisco false appena trovo un numero diverso da zero
        for (int i = 0; i < limit; i++) {
            if (rowA[i] == 0 && rowB[i] != 0) {
                return false;
            }
        }

        return true;
    }

    private void simplifyDiagonal() {
        double multiplier;
        for (int i = 0; i < rows; i++) {
            multiplier = 1 / mx.getRowAsArray(i)[i];
            mx.getRowAsVector(i).mult(multiplier);
            res.getRowAsVector(i).mult(multiplier);
            mx.setRow(i, mx.getRowAsVector(i));
            res.setRow(i, res.getRowAsVector(i));
        }
        System.out.println("SIMPLIFIED MATRIX");
        printMatrix();
    }

    public void solve() {
        while (solveAgain()) {
            printMatrix();
            //procedo riga per riga
            for (int y = 0; y < rows; y++) {

                //Se la cella sulla diagonale � zero scambio l'equazione con una valida
                if (mx.getRowAsVector(0).get(0) == 0) {
                    for (int i = 0; i < rows; i++) {
                        if (mx.getRowAsVector(i).get(y) != 0) {
                            swap(i, y);
                            break;
                        }
                    }
                }

                for (int x = 0; x < cols; x++) {
                    //se non sono nella diagonale allora cerco una riga con la quale annullare il coefficiente
                    if (x != y) {
                        for (int k = 0; k < rows; k++) {
                            //controllo di non essere sulla stessa riga di partenza e che il coefficiente che sto cercando non sia zero
                            if (k != y && mx.getRowAsVector(k).get(x) != 0 && checkZeros(y, k, x)) {
                                //Ay = Ay + Ak*lambda
                                double lambda = getLambda(mx.getRowAsArray(y), mx.getRowAsArray(k), x);
                                if (lambda != 0) {
                                    operation(y, k, lambda);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        simplifyDiagonal();
    }

    public static void test() {
        double[][] mx1 = {{0, -2, 0, 1}, {3, 1, -1, 2}, {1, 0, 1, 1}};

        double[][] res1 = {{1}, {3}, {2}};

        double[][] mx2 = {{2, -6, 0, 4}, {0, 1, 1, 1}, {3, 7, 0, 0}, {3, 8, 1, 0}};

        double[][] res2 = {{1}, {3}, {2}, {2}};

        double[][] mx3 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        double[][] res3 = {{3}, {2}, {2}};

        System.out.println("MATRIX 1");
        GaussJordan gj = new GaussJordan(mx1, res1);
        gj.solve();

        System.out.println("MATRIX 2");
        GaussJordan gj2 = new GaussJordan(mx2, res2);
        gj2.solve();

        System.out.println("MATRIX 3");
        GaussJordan gj3 = new GaussJordan(mx3, res3);
        gj3.solve();
    } */
}

