public class ListElement<T> {

    private T data;
    private ListElement<T> next;

    public ListElement(T value) {
        data = value;
    }

    public ListElement<T> next() {
        return next;
    }

    public T value() {
        return data;
    }

    public void setNext(ListElement<T> elem) {
        next = elem;
    }

    public void setValue(T value) {
        data = value;
    }

    public ListElement<T> insertInFront(ListElement<T> list, T data) {
        ListElement<T> l = new ListElement<T>(data);
        l.setNext(list);
        return l;
    }

    public ListElement<T> find(ListElement<T> head, T data) {
        ListElement<T> elem = head;

        while(elem != null && !elem.value().equals(data))
            elem = elem.next();

        return elem;
    }
}
