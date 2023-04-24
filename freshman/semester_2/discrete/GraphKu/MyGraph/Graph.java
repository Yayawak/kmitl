package MyGraph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// todo : vertexes is generic type

// todo : edges is generic type

public class Graph<T> {
    // Vertex<T> ver
    List<Vertex<T>> vertices = new ArrayList<>();
    public Graph(List<Vertex<T>> vertices) {
        this.vertices = vertices;
    }

    // * : ADJACENT LIST
    public Graph(HashMap<Vertex<T>, ArrayList<Vertex<T>>> adjacencyHashMap) {
        for (Vertex<T> v : adjacencyHashMap.keySet()) {
            vertices.add(v);
            v.setAdjacentVertices(adjacencyHashMap.get(v));
        }
    }
    // public Graph(HashMap<Vertex<T>, ArrayList<Vertex<T>>> adjacencyHashMap) {
    //     for (Vertex<T> v : adjacencyHashMap.keySet()) {
    //         vertices.add(v);
    //         v.setAdjacentVertices(adjacencyHashMap.get(v));
    //     }
    // }
}
