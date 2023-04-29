import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeighedGraph<T> {
    private Map<T, List<Edge<T>>> adjListMap;

    public static class Edge<T> implements Comparable<Edge<T>> {
        T src;
        T dst;
        int weight;

        public Edge(T src, T dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }

        @Override
        public String toString() {
            // return "weight : " + weight;
            // return String.format("destination : %s, weight : %d\n",
            return String.format("source : %s\tdestination : %s, weight : %d\n",
                src, dst, weight
            );
        }

        @Override
        public int compareTo(WeighedGraph.Edge<T> o) {
            return weight - o.weight;
        }
    }

    public WeighedGraph() {
        adjListMap = new HashMap<T, List<Edge<T>>>();
    }

    public void addVertex(T vertex) {
        adjListMap.put(vertex, new LinkedList<Edge<T>>());
    }

    public void addEdge(T src, T dst, int weight) {
        Edge<T> edge = new Edge<T>(src, dst, weight);
        adjListMap.get(src).add(edge);
    }

    public List<Edge<T>> getAdjListOfSingleVertex(T vertex) {
        return adjListMap.get(vertex);
    }

    public List<Edge<T>> getAllEdges() {
        List<Edge<T>> allEdges = new ArrayList<>();
        for (List<Edge<T>> edgesOfEachVertex : adjListMap.values()) {
            for (Edge<T> e : edgesOfEachVertex) {
                allEdges.add(e);
            }
        }
        return (allEdges);
    }

    public List<T> getAllVertices() {
        return new ArrayList<>(adjListMap.keySet());
    }

    public void printGraph() {
        for (T vertex : adjListMap.keySet()) {
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
