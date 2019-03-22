package structures.graph;

/**
 * @author Samir Ettali
 **/
public class SimpleNode extends Node {

    public SimpleNode(String label) {
        super(label);
    }

    @Override
    public String toString() {
        return "SimpleNode { Label: " + this.getLabel() + " }";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SimpleNode) {
            SimpleNode simpleNode = (SimpleNode) obj;
            return this.getLabel().equals(simpleNode.getLabel());
        }
        return false;
    }
}
