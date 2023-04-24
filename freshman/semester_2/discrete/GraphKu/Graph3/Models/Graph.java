package Graph3.Models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class Graph<T> {
    private Map<T, List<T>> map = new HashMap<>();

    public void addNewVertex(T s) {
        // map.putIfAbsent(s, new LinkedList<T>());
        map.put(s, new LinkedList<T>());
    }

    public void addNewEdge(T v1, T v2) {
        if (!map.containsKey(v1))
            addNewVertex(v1);
        if (!map.containsKey(v2))
            addNewVertex(v2);
        map.get(v1).add(v2);
        // handle loop (allow loopable edge)
        // if (v1.equals(v2))
        //     return;
        map.get(v2).add(v1);
    }

    public int countVertices() {
        return map.keySet().size();
    }

    public int countEdges() {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        return count;
    }

    public boolean containsVertex(T s) {
        return map.containsKey(s);
    }

    public boolean containsEdge(T v, T u) {
        if (!map.containsKey(v))
            return false;
        return map.get(v).contains(u);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T v : map.keySet()) {
            builder.append(v.toString() + ": \t");
            for (T u : map.get(v)) {
                builder.append(u.toString() + " \t ");
            }
            builder.append("\n");
            builder.append(">-".repeat(20));
            builder.append("\n");
        }
        return (builder.toString());
    }

    // public int degreeOfVertex(T v) {
    //     if (!map.containsKey(v)) {
    //         System.out.println("Vertex to search is not found in graph");
    //     }
    //     int count = 0;
    //     for (T u : map.keySet()) {
    //         for (T w : map.get(u)) {
    //             if (w.equals(v))
    //                 count++;
    //         }
    //     }
    //     return count;
    // }

    public int outDegreeOfVertex(T v) {
        if (!map.containsKey(v))
            System.out.println("Vertex not found");
        return map.get(v).size();
    }

    public int inDegreeOfVertex(T v) {
        if (!map.containsKey(v))
            System.out.println("Vertex not found");
        int counter = 0;
        for (T u : map.keySet()) {
            if (map.get(u).contains(v))
                counter++;
        }
        return counter;
    }
}
