package Graph2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Graph<K, U> {
    // private ArrayList<Vertex<K>> vertices;
    private boolean isWeighedGraph;
    private boolean isDirected;
    private Map<Vertex<K>, List<Vertex<K>>> adjVertices;

    public Graph(boolean isWeighedGraph, boolean isDirected) {
        // this.vertices = new ArrayList<>();
        this.adjVertices = new HashMap<>();
        this.isWeighedGraph = isWeighedGraph;
        this.isDirected = isDirected;
    }

    void addVertex(K data) {
        this.adjVertices.putIfAbsent(
            new Vertex<K>(data),
            new ArrayList<>()
        );
    }

    void removeVertex(K data) {
        Vertex<K> v = new Vertex<K>(data);
        adjVertices.values().stream()
            .forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex<K>(data));
    }

    void addEdge(K d1, K d2) {
        Vertex<K> v1 = new Vertex<K>(d1);
        Vertex<K> v2 = new Vertex<K>(d2);
        // hashmap structor
        adjVertices.get(v1).add(v2);
        adjVertices.get(v1).add(v2);
    }

    // public void addEdge(Vertex<K> v1, Vertex<K> v2, Integer weight) {
    //     if (!this.isWeighedGraph)
    //         weight = null;
    // v1.addEdge(v2)
    // }

    void removeEdge(K d1, K d2) {
        Vertex<K> v1 = new Vertex<K>(d1);
        Vertex<K> v2 = new Vertex<K>(d2);
        List<Vertex<K>> eV1 = adjVertices.get(v1);
        List<Vertex<K>> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV1 != null)
            eV1.remove(v1);
    }

    // public Map<Vertex<K>, List<Vertex<K>>> getAdjVertices() {
    //     return adjVertices;
    // }

    List<Vertex<K>> getAdjVerticesOf(Vertex<K> v) {
        return adjVertices.get(v);
    }

    // Set<Vertex<K>> depthFirstTraversal(Graph<K, U> graph, Vertex<K> rootV) {
    Set<Vertex<K>> depthFirstTraversal(Vertex<K> rootV) {
        Set<Vertex<K>> visited = new LinkedHashSet<>();
        Stack<Vertex<K>> stack = new Stack<>();
        stack.push(rootV);
        while (!stack.isEmpty()) {
            Vertex<K> vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex<K> v : this.getAdjVerticesOf(vertex)) {
                    stack.push(v);
                }
            }
        }
        return visited;
    }
}
