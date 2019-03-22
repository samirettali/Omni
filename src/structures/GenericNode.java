// Definiamo un nodo "generico" in grado di contenere un elemento di
// tipo qualsiasi T. Cio` si ottiene indicando un parametro di tipo T
// tra parentesi angolari dopo il nome della classe. All'interno della
// classe il tipo T puo` essere usato (quasi) ovunque un tipo e`
// atteso, dunque nelle dichiarazioni di campi, parametri di metodi, e
// variabili locali. T puo` essere usato anche come parametro di tipo
// per fare riferimento ad altre classi o interfacce generiche, come
// accade per il campo next ed il parametro next del costruttore.

public class GenericNode<T> {
    private T elem;
    private GenericNode<T> next;

    public GenericNode(T elem, GenericNode<T> next) {
        this.elem = elem;
        this.next = next;
    }

    public T getElem() {
        return elem;
    }

    public GenericNode<T> getNext() {
        return next;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }

    public void setNext(GenericNode<T> next) {
        this.next = next;
    }
}
