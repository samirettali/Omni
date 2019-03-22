package structures;

import java.util.ArrayList;

public class Branch<T extends Comparable<T>> extends Tree<T> {

    private T elem;
    private Tree<T> left;
    private Tree<T> right;

    public Branch(T elem, Tree<T> left, Tree<T> right) {
        this.elem = elem;
        this.left = left;
        this.right = right;
    }

    public boolean empty() {
        return false;
    }


    public boolean contains(T x) {
        int c = x.compareTo(elem);
        if (c == 0)
            return true;
        else if (c < 0)
            return left.contains(x);
        else
            return right.contains(x);
    }

    public T max() {
        return right.empty() ? elem : right.max();
    }

    public Tree<T> insert(T x) {
        int c = x.compareTo(elem);
        if (c < 0)
            left = left.insert(x);
        else if (c > 0)
            right = right.insert(x);
        return this;

    }

    public Tree<T> remove(T x) {
        int c = x.compareTo(elem);
        if (c == 0)
            if (left.empty())
                return right;
            else if (right.empty())
                return left;
            else {
                elem = left.max();
                left = left.remove(elem);
                return this;
            }
        else if (c < 0) {
            left = left.remove(x);
            return this;
        } else {
            right = right.remove(x);
            return this;
        }
    }

    public int depth() {
        return 1 + Math.max(left.depth(), right.depth());
    }

    public void collect(ArrayList<T> l) {
        left.collect(l);
        l.add(elem);
        right.collect(l);
    }

}
