package structures.minheap;

/**
 * @author Samir Ettali
 **/
public interface PriorityQueue<T> {
    public int parent(int i) throws PriorityQueueException;
    public int left(int i) throws PriorityQueueException;
    public int right(int i) throws PriorityQueueException;
    public void insert(T elem) throws PriorityQueueException;
    public T extractMin() throws PriorityQueueException;
    public T min() throws PriorityQueueException;
    public void decreaseKey(int i, T key) throws PriorityQueueException;
}

