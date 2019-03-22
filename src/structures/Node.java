package structures;

public class Node {

    private int elem;
    private Node next;

    public Node(int elem) {
        this(elem, null);
    }

    public Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }

    public int getElem() {
        return this.elem;
    }

    public void setElem(int elem) {
        this.elem = elem;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node node) {
        this.next = node;
    }
}

