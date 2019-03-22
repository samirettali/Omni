package structures;

import java.util.ArrayList;

public abstract class Tree<T> {
    public abstract boolean empty();

    public abstract int depth();

    public abstract T max();

    public abstract boolean contains(T x);

    public abstract Tree<T> insert(T x);

    public abstract Tree<T> remove(T x);

    public abstract void collect(ArrayList<T> l);
}
