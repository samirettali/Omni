package structures.graph;

/**
 * @author Samir Ettali
 **/
public class Vertex<T extends Node> implements Comparable<Vertex<T>> {

    private T node;
    // TODO change parent from T to Vertex<T>
    private Vertex<T> parent;
    private int pathCost;
    private boolean traversable;
    // TODO implement traversable usage

    public Vertex(T node) {
        this.node = node;
        // TODO improve pathCost
        this.pathCost = Integer.MAX_VALUE;
        this.traversable = true;
    }

    public T getNode() {
        return this.node;
    }

    public Vertex<T> getParent() {
        return this.parent;
    }

    public void setParent(Vertex<T> parent) {
        this.parent = parent;
    }

    public int getPathCost() {
        return this.pathCost;
    }

    public void setPathCost(int pathCost) {
        this.pathCost = pathCost;
    }

    public boolean getTraversable() {
        return this.traversable;
    }

    public void setTraversable(boolean traversable) {
        this.traversable = traversable;
    }

    public String getLabel() {
        return node.getLabel();
    }

    @Override
    public String toString() {
        String s = "Vertex { ";
        s += node;
        s += String.format(", pathCost: %5d }", pathCost);
        return s;
    }

    @Override
    public int compareTo(Vertex<T> vertex) {
        return this.getPathCost() - vertex.getPathCost();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            Vertex vertex = (Vertex) obj;
            return this.node.equals(vertex.getNode());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getNode().hashCode();
    }


}
