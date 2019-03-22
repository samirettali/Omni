package structures.graph;

/**
 * @author Samir Ettali
 **/
public class Edge<T extends Node> {

    private Vertex<T> v1;
    private Vertex<T> v2;
    private int weight;

    public Edge(Vertex<T> v1, Vertex<T> v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "Edge { " + this.v1.getLabel() + " -> " + this.v2.getLabel() + ": " + weight + " }";
    }
}
