package structures.minheap;

import misc.Stopwatch;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Samir Ettali
 **/
public class MinHeap<T extends Comparable<T>> implements PriorityQueue<T> {

    // TODO fix elements to HashSet
    private ArrayList<T> elements;
    // private Comparator<? super T> comparator = null;

    /**
     * MinHeap constructor.
     * @param comparator: comparator of T type elements.
     **/
    /* public MinHeap(Comparator<? super T> comparator) {
        this.elements = new ArrayList<T>();
        this.comparator = comparator;
    } */

    public MinHeap() {
        this.elements = new ArrayList<T>();
    }

    /* public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    } */

    /**
     * MinHeap constructor.
     * @param elements: ArrayList containing the heap elements.
     * @param comparator: comparator of T type elements.
     **/
    /* public MinHeap(ArrayList<T> elements, Comparator<? super T> comparator) {
        this.elements = elements;
        this.comparator = comparator;
    } */

    /**
     * @return boolean: true if the heap is empty, false otherwise.
     **/
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Returns the index of the parent of the element in the i position.
     * @param i: index of the element to get the parent for.
     * @return int: index of the parent of the element in the i position, 0 if
     *  it doesn't have a parent.
     * @throws PriorityQueueException: if index is out of bounds.
     **/
    public int parent(int i) throws PriorityQueueException {
        if (i < 0 || i >= this.size())
            throw new PriorityQueueException("Index out of bounds");
        if (i < this.size())
            return (i - 1) / 2;
        return 0;
    }

    /**
     * Returns the index of the left child of the element in the i position.
     * @param i: index of the element to get the left child for.
     * @return int: index of the left child of the element in the i position, i
     *  if it doesn't have a left child.
     * @throws PriorityQueueException: if the index passed is out of bounds.
     **/
    public int left(int i) throws PriorityQueueException {
        if (i < 0 || i >= this.size())
            throw new PriorityQueueException("Index out of bounds");
        if (i * 2 + 1 < this.size())
            return i * 2 + 1;
        return i;
    }

    /**
     * Returns the index of the right child of the element in the i position.
     * @param i: index of the element to get the right child for.
     * @return int: index of the right child of the element in the i position, i
     *  if it doesn't have a right child.
     * @throws PriorityQueueException: if the index passed is out of bounds.
     **/
    public int right(int i) throws PriorityQueueException {
        if (i < 0 || i >= this.size())
            throw new PriorityQueueException("Index out of bounds");
        if ((i + 1) * 2  < this.size())
            return (i + 1) * 2;
        return i;
    }

    /**
     * Inserts the T element in the heap.
     * This method works by swapping the element with the smaller child until
     * the heap is correctly built.
     * @param element: the element to be inserted in the heap.
     * @throws PriorityQueueException: if the element is null.
     **/
    public void insert(T element) throws PriorityQueueException {
        if (element == null)
            throw new PriorityQueueException("The element to insert is null.");
        int p = this.size();
        this.elements.add(element);
        while (p > 0 && this.elements.get(p).compareTo(this.elements.get(this.parent(p))) < 0) {
            T temp = this.elements.get(p);
            this.elements.set(p, this.elements.get(this.parent(p)));
            this.elements.set(this.parent(p), temp);
            p = this.parent(p);
        }
    }

    /**
     * This method cycles through the list representing the heap and corrects
     * any inconsistency that finds, restoring the heap to it's correct state.
     * @param i: the index to start restoring the heap from.
     * @throws PriorityQueueException: if the index passed is greater than the
     * last element's index.
     **/
    public void heapify(int i) throws PriorityQueueException {
        if (i < 0 || i >= this.size())
            throw new PriorityQueueException("Index out of bounds");

        int min = i;
        T left = this.elements.get(this.left(i));
        T right = this.elements.get(this.right(i));
        T elem = this.elements.get(i);

        if (elem.compareTo(left) > 0)
            min = this.left(i);

        if (this.elements.get(min).compareTo(right) > 0)
            min = this.right(i);

        // int m = this.comparator.compare(this.elements.get(i), this.elements.get(this.left(i))) < 0 ? i : this.left(i);
        // m = this.comparator.compare(this.elements.get(m), this.elements.get(this.right(i))) < 0 ? m : this.right(i);

        if (min != i) {
            T temp = this.elements.get(min);
            this.elements.set(min, this.elements.get(i));
            this.elements.set(i, temp);
            this.heapify(min);
        }
    }

    public int isValid() throws PriorityQueueException {
        for (int i = 0; i < elements.size() ; i++) {
            int left = left(i);
            int right = right(i);
            if (i != left) {
                if (elements.get(i).compareTo(elements.get(left)) > 0)
                    return i;
            }

            if (i != right) {
                if (elements.get(i).compareTo(elements.get(right)) > 0)
                    return -i;
            }
        }
        return 0;
    }

    /**
     * Remove and return the minimum from the heap.
     * @return T: the smallest element of the heap.
     * @throws PriorityQueueException: if there is no element in the heap.
     **/
    public T extractMin() throws PriorityQueueException {
        if (this.size() == 0)
            throw new PriorityQueueException("Priority queue is empty, can't extract minimum.");
        T head = elements.get(0);
        this.elements.set(0, this.elements.remove(this.size() - 1));
        this.heapify(0);
        return head;
    }

    /**
     * Decrease the key of the element in i position.
     * @param i: index of the heap's element in the list.
     * @param key: new element's key.
     * @throws PriorityQueueException: when the new key is greater than the
     * current key.
     **/
    public void decreaseKey(int i, T key) throws PriorityQueueException {
        if (key.compareTo(this.elements.get(i)) > 0)
            throw new PriorityQueueException("New key is greater than current key.");
        this.elements.set(i, key);
        while (i >= 1 && this.elements.get(parent(i)).compareTo(this.elements.get(i)) > 0) {
            T temp = this.elements.get(i);
            this.elements.set(i, this.elements.get(parent(i)));
            this.elements.set(parent(i), temp);
            i = parent(i);
        }
    }

    /**
     * Only return the minimum value in the heap without removing it.
     * @return T: minimum value in the heap.
     * @throws PriorityQueueException: if there is no element in the heap.
     **/
    public T min() throws PriorityQueueException {
        if (elements.size() == 0)
            throw new PriorityQueueException("Priority queue is empty, can't get minimum.");
        return elements.get(0);
    }

    /**
     * Extract minimum element from and return it
     * @return index of the minimum element on right sub-heap.
     * @throws PriorityQueueException: if there is no element in the heap.
     **/
    public T extractMinimum() throws PriorityQueueException{
        if (this.elements.size() == 0)
            throw new PriorityQueueException("Priority queue is empty, can't extract minimum.");
        T result = this.elements.get(0);
        if (this.elements.size() == 1) {
            this.elements.remove(0);
            return result;
        }
        this.elements.set(0, this.elements.get(this.size() - 1));
        this.elements.remove(this.size() - 1);
        this.heapify(0);
        return result;
    }


    /**
     * @return int: numbers of elements within the heap.
     **/
    public int size() {
        return this.elements.size();
    }

    /**
     * Build the string representing the heap.
     * @return String: the list representing the heap.
     **/
    public String toString() {
        if (this.size() == 0)
            return "[]";

        String s = "[";
        for (T element : elements)
            s += element + ", ";
        return s + "\b\b]";
    }

    public ArrayList<T> getList() {
        return this.elements;
    }

    public boolean contains(T element) {
        return elements.contains(element);
    }
}


