package structures;


public class Stack {

    Node top;

    public Stack() {
        this.top = null;
    }

    public void push(int n) {
        top = new Node(n, top);
    }

    public int pop() {
        assert !empty();
        int n = top.getElem();
        top = top.getNext();
        return n;
    }

    public boolean empty() {
        return top == null;
    }

    public int top() {
        assert !empty();
        return top.getElem();
    }
}

