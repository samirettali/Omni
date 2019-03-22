package structures;

import java.io.PrintStream;

public class SinglyLinkedList {
    int size;
    Node head;

    public SinglyLinkedList() {
        size = 0;
        head = null;
    }

    public void add(int data) {
        add(size, data);
    }

    public void addAtBegin(int data) {
        add(0, data);
    }

    public void add(int index, int data) {
        assert (index <= size);
        if (index == 0)
            head = new Node(data, head);
        else {
            Node previous = getNode(index - 1);
            previous.setNext(new Node(data, previous.getNext()));
        }
        size++;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size - 1);
    }

    public void remove(int index) {
        assert (index < size);
        if (index == 0)
            head = head.getNext();
        else {
            Node previous = getNode(index - 1);
            previous.setNext(previous.getNext().getNext());
        }
        size--;
    }

    public int get(int index) {
        assert (index < size);
        Node temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.getNext();
        return temp.getElem();
    }

    public String toString() {
        String s = "[";
        Node temp = head;
        while (temp != null) {
            s += temp.getElem();
            temp = temp.getNext();
            if(temp != null)
                s += ", ";
        }
        s += "]";
        return s;
    }

    public int size() {
        return size;
    }

    private Node getNode(int index) {
        assert index < size;
        Node temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.getNext();
        return temp;
    }

    public int nthFromEnd(int position) {
        Node temp = head;
        Node cursor = head;

        while(cursor != null && position > 1) {
            cursor = cursor.getNext();
            position--;
        }

        if(cursor != null) {
            while(cursor.getNext() != null) {
                cursor = cursor.getNext();
                temp = temp.getNext();
            }
        }

        return cursor == null ? -1 : temp.getElem();
    }

}
