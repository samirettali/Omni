package structures;

import java.util.ArrayList;

public class Leaf<T extends Comparable<T>> extends Tree<T> {

    public Leaf() {

    }

    public Tree<T> insert(T elem) {
        return new Branch<>(elem, this, this);
    }

    public Tree<T> remove(T elem) {
        return this;
    }

    public T max() {
        throw new IllegalStateException("max on empty tree");
    }

    public int depth() {
        return 0;
    }

    public boolean empty() {
        return true;
    }

    public boolean contains(T elem) {
        return false;
    }

    public void collect(ArrayList<T> l) {

    }

}

