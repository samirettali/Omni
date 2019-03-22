package structure;

/**
 * Created by Sam on 27/02/2017.
 */
public class Vector {

    private double[] array;
    private int size;

    public Vector(int size) {
        this.array = new double[size];
        this.size = size;
    }

    public Vector(double[] array) {
        this.array = array;
    }

    public void sum(Vector a) {
        if (array.length == a.size())
            for (int i = 0; i < this.size; i++)
                this.array[i] += a.get(i);
    }

    public void sub(Vector a) {
        a.mult(-1);
        sum(a);
        a.mult(-1);
    }

    public void mult(double n) {
        for (int i = 0; i < this.array.length; i++)
            this.array[i] *= n;
    }

    // Get
    public double get(int i) {
        return this.array[i];
    }

    public double[] getArray() {
        return this.array;
    }

    // Set
    public void set(int index, double value) {
        array[index] = value;
    }

    public void set(double[] array) {
        this.array = array;
    }

    public int size() {
        return this.size;
    }
}
