package structures.graph;

/**
 * @author Samir Ettali
 **/
public abstract class Node {

    private String label;

    public Node(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public int hashCode() {
        return this.label.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            Node node = (Node) obj;
            return node.getLabel().equals(this.label);
        }
        return false;
    }
}
