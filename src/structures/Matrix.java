package structure;

public class Matrix {

    private Vector[] matrix;
    private int rows, cols;

    // Costruttori
    public Matrix(int rows, int cols) {
        matrix = new Vector[rows];
        for (int i = 0; i < cols; i++)
            matrix[i] = new Vector(cols);
        this.rows = rows;
        this.cols = cols;
    }

    public Matrix(double[][] matrix) {
        set(matrix);
    }

    // Get
    public double[][] getAsMatrix() {
        double[][] array = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            array[i] = getRowAsArray(i);
        return array;
    }

    public double get(int row, int col) {
        return matrix[row].get(col);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Vector getRowAsVector(int x) {
        return matrix[x];
    }

    public double[] getRowAsArray(int x) {
        return matrix[x].getArray();
    }

    public Vector getColAsVector(int x) {
        Vector vec = new Vector(rows);
        for (int i = 0; i < rows; i++)
            vec.set(i, matrix[i].get(x));
        return vec;
    }

    public double[] getColAsArray(int x) {
        double[] array = new double[rows];
        for (int i = 0; i < rows; i++)
            array[i] = matrix[i].get(x);
        return array;
    }

    // Set
    public void set(double[][] matrix) {
        Vector temp = new Vector(cols);
        for (int i = 0; i < matrix.length; i++)
            this.matrix[i].set(matrix[i]);
        rows = matrix.length;
        cols = matrix[0].length;
    }

    public void set(int row, int col, double value) {
        matrix[row].set(col, value);
    }

    public void setRow(int n, double[] row) {
        matrix[n].set(row);
    }

    public void setRow(int n, Vector row) {
        matrix[n] = row;
    }

    public void setCol(int n, double[] row) {
        for (int i = 0; i < rows; i++)
            matrix[i].set(n, row[i]);
    }


    public String size() {
        return matrix.length + "x" + matrix[0].size();
    }

    public void transpose() {

        double[][] t = new double[cols][rows];

        for (int i = 0; i < cols; i++)
            for (int j = 0; j < rows; j++)
                t[i][j] = matrix[j].get(i);

        set(t);

        int temp = cols;
        cols = rows;
        rows = temp;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.print(matrix[i].get(j) + " ");
            System.out.println();
        }
    }

    public void sum(Matrix m) {
        if (m.getCols() == cols && m.getRows() == rows)
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    matrix[i].set(j, matrix[i].get(j) + m.get(i, j));
        else
            System.out.println("Error: the sum of two matrices requires them to be the same size.");
    }

    public void mult(Matrix m) {

        Matrix res = new Matrix(rows, m.getCols());
        int i, j, k;
        double sum;

        if (cols == m.getRows()) {
            for (i = 0; i < rows; i++) {
                for (j = 0; j < m.getCols(); j++) {
                    sum = 0;
                    for (k = 0; k < cols; k++)
                        sum += matrix[i].get(k) * m.get(k, j);

                    res.set(i, j, sum);


                }
            }

            cols = m.getCols();
            for (i = 0; i < rows; i++)
                matrix[i] = res.getRowAsVector(i);


        }


    }
}
