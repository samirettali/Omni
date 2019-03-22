package structures;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph<T> {

    private HashMap<T, ArrayList<Edge<T>>> adjacencyList;

    private ArrayList<T> vertexList;

    private boolean directed;

    public Graph(boolean isDirected) {
        this.directed = isDirected;
        adjacencyList = new HashMap<T, ArrayList<Edge<T>>>();
        vertexList = new ArrayList<T>();
    }

    public void add(T vertex, ArrayList<Edge<T>> connectedVertices) {
        adjacencyList.put(vertex, connectedVertices);
        vertexList.add(vertex);
        for(Edge<T> vertexConnectedToAddedVertex: connectedVertices) {
            ArrayList<Edge<T>> correspondingConnectedList = adjacencyList.get(vertexConnectedToAddedVertex.getVertex());
            if (correspondingConnectedList == null) {
                adjacencyList.put(vertexConnectedToAddedVertex.getVertex(), new ArrayList<Edge<T>>());
                vertexList.add(vertexConnectedToAddedVertex.getVertex());
                correspondingConnectedList = adjacencyList.get(vertexConnectedToAddedVertex.getVertex());
            }

            if (!directed) {
                int weight = vertexConnectedToAddedVertex.getWeight();
                correspondingConnectedList.add(new Edge<T>(vertex, weight));
            }
        }
    }

    public boolean addArc(T source, T end, int weight) {
        if(!directed)
            return false;

        if(!adjacencyList.containsKey(source)) {
            ArrayList<Edge<T>> tempList = new ArrayList<Edge<T>>();
            tempList.add(new Edge<T>(end, weight));
            add(source, tempList);
            return true;
        }

        /*if(!adjacencyList.contains(end)) {
            ArrayList<Edge<T>> tempList = new ArrayList<Edge<T>>();
            add(end, tempList);
        }*/

        adjacencyList.get(source).add(new Edge<T>(end, weight));
        return true;
    }
    public boolean addEdge(T vertexOne, T vertexTwo, int weight) {
        if (directed) {
            return false;
        }

        if (!adjacencyList.containsKey(vertexOne)) {
            ArrayList<Edge<T>> tempList = new ArrayList<Edge<T>>();
            tempList.add(new Edge<T>(vertexTwo, weight));
            add(vertexOne, tempList);
            return true;
        }

        if (!adjacencyList.containsKey(vertexTwo)) {
            ArrayList<Edge<T>> tempList = new ArrayList<Edge<T>>();
            tempList.add(new Edge<T>(vertexOne, weight));
            add(vertexTwo, tempList);
            return true;
        }

        adjacencyList.get(vertexOne).add(new Edge<T>(vertexTwo, weight));
        adjacencyList.get(vertexTwo).add(new Edge<T>(vertexOne, weight));
        return true;
    }

    /**
     * This method returns a list of all adjacent vertices of the give vertex without weight
     *
     * @param vertex the source vertex
     * @return an array list containing the vertices
     */
    public ArrayList<T> getAdjacentVertices(T vertex){
        ArrayList<T> returnList = new ArrayList<T>();
        for (Edge<T> edge : adjacencyList.get(vertex)) {
            returnList.add(edge.getVertex());
        }
        return returnList;
    }

    public double getDistanceBetween(T source, T end){
        for (Edge<T> edge : adjacencyList.get(source)) {
            if (edge.getVertex() == end){
                return edge.getWeight();
            }
        }
        return Double.POSITIVE_INFINITY;
    }

    public ArrayList<T> getVertexList() {
        return vertexList;
    }

    public String toString() {
        String s = "";
        for (T vertex : vertexList) {
            s += vertex.toString();
            s += " : ";
            s += adjacencyList.get(vertex);
            s += "\n";
        }
        return s;
    }
}
