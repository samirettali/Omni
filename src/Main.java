import euler.*;
import misc.Stopwatch;
import structures.graph.Graph;
import structures.graph.SimpleNode;
import structures.graph.Vertex;
import structures.minheap.MinHeap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Main {

    public static void graphTest() {
        try {
            Graph<SimpleNode> graph = new Graph<>(false);
            SimpleNode n0 = new SimpleNode("0");
            SimpleNode n1 = new SimpleNode("1");
            SimpleNode n2 = new SimpleNode("2");
            SimpleNode n3 = new SimpleNode("3");
            SimpleNode n4 = new SimpleNode("4");
            SimpleNode n5 = new SimpleNode("5");
            SimpleNode n6 = new SimpleNode("6");
            SimpleNode n7 = new SimpleNode("7");
            SimpleNode n8 = new SimpleNode("8");
            Vertex<SimpleNode> v0 = new Vertex(n0);
            Vertex<SimpleNode> v1 = new Vertex(n1);
            Vertex<SimpleNode> v2 = new Vertex(n2);
            Vertex<SimpleNode> v3 = new Vertex(n3);
            Vertex<SimpleNode> v4 = new Vertex(n4);
            Vertex<SimpleNode> v5 = new Vertex(n5);
            Vertex<SimpleNode> v6 = new Vertex(n6);
            Vertex<SimpleNode> v7 = new Vertex(n7);
            Vertex<SimpleNode> v8 = new Vertex(n8);
            graph.addEdge(v0, v1, 4);
            graph.addEdge(v0, v7, 8);
            graph.addEdge(v1, v7, 11);
            graph.addEdge(v1, v2, 8);
            graph.addEdge(v7, v8, 7);
            graph.addEdge(v7, v6, 1);
            graph.addEdge(v6, v8, 6);
            graph.addEdge(v8, v2, 2);
            graph.addEdge(v2, v5, 4);
            graph.addEdge(v2, v3, 7);
            graph.addEdge(v6, v5, 2);
            graph.addEdge(v5, v3, 14);
            graph.addEdge(v5, v4, 10);
            graph.addEdge(v3, v4, 9);
            graph.printPath(v0, v4);
            // System.out.println(graph);
            System.out.println("Vertices: " + graph.getVerticesNumber());
            System.out.println("Edges: " + graph.getEdgesNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void numberphileGraph() {
        try {
            Graph<SimpleNode> graph = Graph.loadGraph("/home/samir/code/java/omni/src/datasets/numberphile_graph.txt");
            graph.printPath(graph.getNode("S"), graph.getNode("E"));
            System.out.println(graph);
            System.out.println("Vertices: " + graph.getVerticesNumber());
            System.out.println("Edges: " + graph.getEdgesNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void graphBenchmark() throws Exception{
        Stopwatch sw = new Stopwatch();

        for (int i = 25; i < 100000; i *= 2) {
            for (int j = 0; j < 5; j++) {
                Graph<SimpleNode> graph = Graph.randomGraph(i, 50);
                HashSet<Vertex<SimpleNode>> vertices = graph.getVertices();
                Vertex<SimpleNode> vertex = vertices.iterator().next();
                sw.start();
                graph.dijkstra(vertex);
                sw.printMilli("Vertices " + graph.getVerticesNumber() + ", edges " + graph.getEdgesNumber() + " ->");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        graphBenchmark();
        // graphTest();
        numberphileGraph();
        // E41.start();
        /* MinHeap<Integer> heap = new MinHeap<>();
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            heap.insert(random.nextInt(100));
        }
        System.out.println(heap);
        for (int i = 0; i < 12; i++) {
            System.out.println(heap.extractMinimum());
        } */
    }
}
