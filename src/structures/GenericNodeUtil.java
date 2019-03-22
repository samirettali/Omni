// versioni generiche di alcuni dei metodi di utilita` visti in
// precedenza per i nodi. Tutte le operazioni che NON usano proprieta`
// particolari degli elementi possono essere implementate come metodi
// generici. Le operazioni fromTo, fromArray, zipSum fanno assunzioni
// sul tipo degli elementi delle liste che producono/manipolano e
// dunque non e` sensato (o comunque semplice) fornire implementazioni
// generiche di queste operazioni.
public class GenericNodeUtil {
    public static GenericNode<Integer> fromTo(int m, int n) {
        return m > n ? null : new GenericNode<>(m, fromTo(m + 1, n));
    }

    public static GenericNode<String> fromArray(String[] a) {
        GenericNode<String> p = null;
        for (int i = a.length - 1; i >= 0; i--)
            p = new GenericNode<>(a[i], p);
        return p;
    }

    public static <T> int size(GenericNode<T> p) {
        return p == null ? 0 : 1 + size(p.getNext());
    }

    public static <T> String toString(GenericNode<T> p) {
        String res = "[";
        while (p != null) {
            res += p.getElem().toString();
            p = p.getNext();
            if (p != null) res += ", ";
        }
        return res + "]";
    }

    public static <T> int occurrences(GenericNode<T> p, T x) {
        int n = 0;
        while (p != null) {
            if (p.getElem().equals(x)) n++;
            p = p.getNext();
        }
        return n;
    }

    public static <T> boolean equals(GenericNode<T> p, GenericNode<T> q) {
        while (p != null && q != null && p.getElem().equals(q.getElem())) {
            p = p.getNext();
            q = q.getNext();
        }
        return p == null && q == null;
    }

    public static <T> GenericNode<T> reverse(GenericNode<T> p) {
        GenericNode<T> q = null;
        while (p != null) {
            q = new GenericNode<>(p.getElem(), q);
            p = p.getNext();
        }
        return q;
    }

    public static GenericNode<Integer> zipSum(GenericNode<Integer> p,
                                              GenericNode<Integer> q) {
        assert (p == null && q == null) || (p != null && q != null);
        if (p == null && q == null)
            return null;
        else
            return new GenericNode<Integer>(p.getElem() + q.getElem(),
                    zipSum(p.getNext(), q.getNext()));
    }

    // ALCUNI TEST

    public static void main(String[] args) {
        GenericNode<Integer> p = fromTo(0, 10);
        System.out.println(size(p));
        System.out.println(GenericNodeUtil.<Integer>size(p));

        GenericNode<String> q = fromArray(args);
        System.out.println(size(q));

        System.out.println(toString(p));
        System.out.println(toString(q));

        System.out.println(toString(zipSum(p, p)));
        // System.out.println(toString(zipSum(p, q))); // TYPE ERROR

        System.out.println(occurrences(q, "ciao"));
    }
}
