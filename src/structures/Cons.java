package structures;

public class Cons extends List {
    private int elem;
    private List next;

    public Cons(int elem, List next) {
        this.elem = elem;
        this.next = next;
    }

    public String toString() {
        return elem + " " + next.toString();
    }

    public List insert(int n, int x) {
        List head = this;
        List l = head;

        while (l != null && n > 0) {
            n--;
            l = next;
            ;
        }

        return head;
    }

    public static void main(String[] args) {
        List list = new Cons(3, new Cons(2, new Nil()));

        System.out.println(list.toString());
        System.out.println(list.insert(1, -1).toString());
    }
}