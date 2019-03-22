package structures;
import java.util.ArrayList;

public class HashTable<T> {

    private Object[] table;
    private int size = 100;

    public HashTable() {
        table = new Object[size];
    }

    private int hash(int key, int i) {
        return ((key % 5) + i) % 5;
    }

    public int insert(int key, T element) {
        System.out.println("INSERT(" + key + ", " + element + ")");
        int i = 0;
        while (i < this.size) {
            int j = this.hash(key, i);
            if (table[j] == null) {
                table[j] = element;
                System.out.println("    " + j);
                return j;
            }
            i++;
        };
        System.out.println("    -1");
        return -1;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < this.size; i++)
            s += i + " " + table[i] + "\n";
        return s;
    }
}
