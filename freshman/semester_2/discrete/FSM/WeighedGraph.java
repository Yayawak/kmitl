import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeighedGraph<T> {
    private Map<Vertex<T>, List<Edge<T>>> adjListMap;


    protected WeighedGraph() {
        adjListMap = new HashMap<Vertex<T>, List<Edge<T>>>();
    }

    protected void addVertex(Vertex<T> vertex) {
        adjListMap.put(vertex, new LinkedList<Edge<T>>());
    }

    protected void addEdge(Vertex<T> src, Vertex<T> dst, int weight) {
        Edge<T> edge = new Edge<T>(src, dst, weight);
        adjListMap.get(src).add(edge);
    }

    // public List<Edge<T>> getAdjListOfSingleVertex(T vertex) {
    protected List<Edge<T>> getAdjListOfSingleVertex(Vertex<T> vertex) {
        return adjListMap.get(vertex);
    }

    protected List<Edge<T>> getAllEdges() {
        List<Edge<T>> allEdges = new ArrayList<>();
        for (List<Edge<T>> edgesOfEachVertex : adjListMap.values()) {
            for (Edge<T> e : edgesOfEachVertex) {
                allEdges.add(e);
            }
        }
        return (allEdges);
    }

    public List<Vertex<T>> getAllVertices() {
        return new ArrayList<>(adjListMap.keySet());
    }

    public void printGraph() {
        for (Vertex<T> vertex : adjListMap.keySet()) {
            System.out.printf("From source : \"%s\"\n", vertex);
            if (adjListMap.get(vertex).size() == 0) {
                System.out.println("No a single destination");
            } else {
                System.out.println("To");
                for (Edge<T> connectedEdge : adjListMap.get(vertex)) {
                    System.out.printf("\t%s", connectedEdge);
                }
            }
            System.out.println("------".repeat(20));
        }
    }

}
