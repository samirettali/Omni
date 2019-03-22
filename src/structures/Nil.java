package structures;

public class Nil extends List {

    public Nil() {

    }

    public List insert(int n, int x) {
        if (n != 0)
            throw new IndexOutOfBoundsException("Invalid n");
        return new Cons(x, this);
    }

    public String toString() {
        return "";
    }
}

