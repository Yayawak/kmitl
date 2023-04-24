package Graph2;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    private T data;
    private List<Vertex<T>> adjacentVertices = new ArrayList<>();
    public Vertex(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public void addEdge(Vertex<T> v, Integer weight) {
        // this.adjacentVertices.add(Ve)
    }
    // public List<Vertex<T>> getAdjacentVertices() {
    //     return adjacentVertices;
    // }
    // public void setAdjacentVertices(List<Vertex<T>> adjacentVertices) {
    //     this.adjacentVertices = adjacentVertices;
    // }
    // public void setAdjacentVertices(Vertex<T>... adjV) {
    //     // this.adjacentVertices = adjV;
    //     // this.adjacentVertices = Arrays.asList(adjV);
    //     for (Vertex<T> v : adjV)
    //         addAdjacentVertex(v);
    // }
    // public void addAdjacentVertex(Vertex<T> v) {
    //     adjacentVertices.add(v);
    // }
    // public void removeAdjacentVertex(Vertex<T> v) {
    //     adjacentVertices.remove(v);
    // }
    // @Override
    // public String toString() {
    //     return "Vertex [data=" + data + ", adjacentVertices=" + adjacentVertices + "]";
    // }
}
