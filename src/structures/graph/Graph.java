package structures.graph;

import structures.minheap.MinHeap;
import structures.minheap.PriorityQueueException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Samir Ettali
 **/

public class Graph<T extends Node> {
    private boolean oriented;
    private HashSet<Vertex<T>> vertices;
    private HashSet<Edge<T>> edges;
    private HashMap<Vertex<T>, HashMap<Vertex<T>, Integer>> adjacencyList;

    /**
     * Graph constructor.
     * @param oriented: distinguish oriented and not oriented graphs.
     **/
    public Graph(boolean oriented) {
        this.oriented = oriented;
        this.adjacencyList = new HashMap<>();
        this.vertices = new HashSet<>();
        this.edges = new HashSet<>();
    }


    public HashSet<Vertex<T>> getVertices() {
        return this.vertices;
    }

    /**
     * @return HashMap: graph structure.
     **/
    public HashMap<Vertex<T>, HashMap<Vertex<T>, Integer>> getAdjacencyList() {
        return this.adjacencyList;
    }

    /**
     * Returns the vertices adjacent to the given one
     * @param vertex the vertex to search adjacents for
     * @return Vertex<T>: the adjacents vertices to the given one
     */
    public ArrayList<Vertex<T>> getAdjacentVertices(Vertex<T> vertex) {
        HashMap<Vertex<T>, Integer> adjacentNodes = this.adjacencyList.get(vertex);
        ArrayList<Vertex<T>> neighborVertex = new ArrayList<>();

        if (adjacentNodes != null && !adjacentNodes.isEmpty()) {
            for (Vertex<T> v : adjacentNodes.keySet())
                neighborVertex.add(v);
        }
        return neighborVertex;
    }

    /**
     * Returns the number of vertices
     * @return int: the number of vertices
     */
    public int getVerticesNumber() {
        return this.vertices.size();
    }

    /**
     * Returns the number of edges
     * @return int: the number of edges
     */
    public int getEdgesNumber() {
        return this.oriented ? this.edges.size() : this.edges.size() / 2;
    }

    public Vertex<T> getNode(String label) {
        for (Vertex<T> vertex : vertices) {
            if (vertex.getLabel().equals(label))
                return vertex;
        }
        return null;
    }

    /**
     * Add and edge between two vertices.
     * @param src: the first vertex of the edge.
     * @param dst: the second vertex of the edge.
     **/
    public void addEdge(Vertex<T> src, Vertex<T> dst, int weight) {
        Objects.requireNonNull(src);
        Objects.requireNonNull(dst);

        // TODO migliorare
        for (Vertex<T> vertex : vertices) {
            if (vertex.equals(src))
                src = vertex;
            if (vertex.equals(dst))
                dst = vertex;
        }


        this.edges.add(new Edge<>(src, dst, weight));
        HashMap<Vertex<T>, Integer> adjacentVertices = this.adjacencyList.get(src);
        // TODO forse isempty non serve
        if (adjacentVertices == null || adjacentVertices.isEmpty())
            adjacentVertices = new HashMap<>();
        adjacentVertices.put(dst, weight);
        this.adjacencyList.put(src, adjacentVertices);

        if (!oriented) {
            this.edges.add(new Edge<>(dst, src, weight));
            adjacentVertices = this.adjacencyList.get(dst);
            if (adjacentVertices == null || adjacentVertices.isEmpty())
                adjacentVertices = new HashMap<>();
            adjacentVertices.put(src, weight);
            this.adjacencyList.put(dst, adjacentVertices);
        }

        this.vertices.add(src);
        this.vertices.add(dst);
    }

    public void initDistances() {
        for (Vertex<T> vertex : vertices) {
            vertex.setPathCost(Integer.MAX_VALUE);
            vertex.setParent(null);
        }
    }

    /**
     * Applies Dijkstra algorithm to the graph
     * @param start the node to start from
     * @throws PriorityQueueException
     */
    public void dijkstra(Vertex<T> start) throws PriorityQueueException {
        // TODO replace MinHeap with ArrayList
        MinHeap<Vertex<T>> queue = new MinHeap<>();

        this.initDistances();
        start.setPathCost(0);
        start.setParent(null);

        // Initializing start's adjacents vertices
        for (Vertex<T> v : this.getAdjacencyList().get(start).keySet()) {
            v.setPathCost(adjacencyList.get(start).get(v));
            v.setParent(start);
        }

        for (Vertex<T> vertex : vertices)
            queue.insert(vertex);

        while (!queue.isEmpty()) {
            Vertex<T> vertex = queue.extractMinimum();
            HashMap<Vertex<T>, Integer> adjacentVertices = this.getAdjacencyList().get(vertex);
            adjacentVertices =
                    adjacentVertices.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            for (Vertex<T> adj : adjacentVertices.keySet()) {
                // TODO invece di usare contains usare parent != null
                if (queue.contains(adj) && vertex.getPathCost() + adjacentVertices.get(adj) < adj.getPathCost() && vertex.getPathCost() + adjacentVertices.get(adj) > 0) {
                    adj.setPathCost(vertex.getPathCost() + adjacentVertices.get(adj));
                    adj.setParent(vertex);
                }
            }
            for (int i = queue.size() - 1; i > 0; i--)
                queue.heapify(i);
        }
    }

    public void printPath(Vertex<T> start, Vertex<T> destination) throws PriorityQueueException {
        this.dijkstra(start);
        System.out.println("The path costs " + destination.getPathCost());
        String path = destination.getLabel();
        while (destination.getParent() != null) {
            path = destination.getParent().getLabel() + " -> " + path;
            destination = destination.getParent();
        }
        System.out.println(path);
    }

    /**
     * Return a random generated graph of SimpleNode
     * @param size the number of vertices
     * @return the generated Graph
     */
    public static Graph<SimpleNode> randomGraph(int size, int maximumWeight) {
        Random random = new Random();
        Graph<SimpleNode> graph = new Graph<>(false);
        ArrayList<Vertex<SimpleNode>> vertices = new ArrayList<>();
        /* Vertices creation */
        for (int i = 1; i <= size; i++)
            vertices.add(new Vertex<>(new SimpleNode(Integer.toString(i))));

        /* Edges creation */
        for (Vertex<SimpleNode> vertex : vertices) {
            Vertex<SimpleNode> adj;
            int edges = random.nextInt(10);
            for (int i = 0; i < edges; i++) {
                /* Extraction of a random vertex */
                do {
                    adj = vertices.get(random.nextInt(size));
                } while (vertex.equals(adj));

                /* If the edge is not already present */
                ArrayList<Vertex<SimpleNode>> adjacents = graph.getAdjacentVertices(vertex);
                if (adjacents == null || !adjacents.contains(adj))
                    graph.addEdge(vertex, adj, random.nextInt(maximumWeight));
            }
        }
        return graph;
    }

    public static Graph<SimpleNode> loadGraph(String filename) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        Graph<SimpleNode> graph = new Graph<>(false);

        String line;

        while ((line = br.readLine()) != null) {
            String[] splittedLine = line.split(" ");
            Vertex<SimpleNode> src = new Vertex<>(new SimpleNode(splittedLine[0]));
            Vertex<SimpleNode> dst = new Vertex<>(new SimpleNode(splittedLine[1]));
            graph.addEdge(src, dst, Integer.parseInt(splittedLine[2]));
        }
        return graph;
    }

    /**
     * Returns a string representing the graph.
     * @return String: the string representing the graph.
     **/
    public String toString() {
        String result = "Graph {\n";
        for (Vertex<T> vertex : vertices)
            result += "\t" + vertex + "\n";
        for (Edge<T> edge : edges)
            result += "\t" + edge + "\n";

        result += "}";
        return result;
    }
}
