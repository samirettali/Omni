package structures;

import java.io.PrintStream;

public class CircularLinkedList {
    Node head;
    int size;

    public CircularLinkedList() {
        size = 0;
        head = null;
    }

    public void add(int index, int data) {
        assert (index <= size);

        Node newNode = new Node(data, null);

        // se devo aggiungere in testa
        if (index == 0) {
            // se head è null diventa newNode e setto il riferimento al next node
            if (head == null) {
                head = newNode;
                head.setNext(head);
            }
            // altrimenti cerco l'ultimo node e cambio il riferimento al next node
            // con newNode poi setto la nuova head
            else {
                Node temp = head;
                while (temp.getNext() != head)
                    temp = temp.getNext();
                temp.setNext(newNode);
                newNode.setNext(head);
                head = newNode;
            }
        }
        // altrimenti cerco il node corrispondende alla posizione prima di quella
        // scelta e cambio i riferimenti
        else {
            Node temp = head;
            index--;
            for (int i = 0; i < index; i++)
                temp = temp.getNext();
            temp.setNext(new Node(data, temp.getNext()));
        }
        size++;
    }

    public void add(int data) {
        add(size, data);
    }

    public void addAtBegin(int data) {
        add(0, data);
    }

    public void set(int index, int data) {
        assert index < size;
        Node temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.getNext();
        temp = new Node(data, temp.getNext());

    }

    public void remove(int index) {
        assert index < size;
        Node temp;
        if (index == 0) {
            if (head.getNext() == head)
                head = null;
            else {
                temp = getNode(size - 1);
                temp.setNext(head.getNext());
                head = head.getNext();
            }
        } else {
            temp = getNode(index - 1);
            temp.setNext(temp.getNext().getNext());
        }
        size--;
    }

    public void removeFirst() {
        remove(0);
    }

    public void deleteLast() {
        remove(size - 1);
    }

    public int get(int index) {
        assert index < size;
        Node temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.getNext();
        return temp.getElem();
    }

    private Node getNode(int index) {
        assert index < size;
        Node temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.getNext();
        return temp;
    }

    public void print() {
        if (head != null) {
            Node temp = head;
            do {
                System.out.print(temp.getElem() + " ");
                temp = temp.getNext();
            } while (temp != head);
            System.out.println();
        } else
            System.out.println("null");
    }

    public int size() {
        return size;
    }
}
