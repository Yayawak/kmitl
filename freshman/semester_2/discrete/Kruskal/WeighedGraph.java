import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeighedGraph<T> {
// public class WeighedGraph<T> implements CanCalculateMst<T> {
    private Map<T, List<Edge<T>>> adjListMap;

    // private static class Edge<T> implements Comparable<Edge<T>> {
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
        // for (Edge<T> e : adjListMap.get(vertex)) {
            // System.out.println("edge conntected : " + e);
        // }
        // System.out.printf("from %s\n", vertex);
        // System.out.println(adjListMap.get(vertex));
        return adjListMap.get(vertex);
    }

    public List<Edge<T>> getAllEdges() {
        List<Edge<T>> allEdges = new ArrayList<>();
        // List<Edge<T>> allEdges = adjListMap.values().stream()
            // .map(listOfEdges -> listOfEdges).toList();

        for (List<Edge<T>> edgesOfEachVertex : adjListMap.values()) {
            for (Edge<T> e : edgesOfEachVertex) {
                allEdges.add(e);
                // System.out.println("edges " + e);
            }
        }

        return (allEdges);
    }

    public List<T> getAllVertices() {
        // return adjListMap.keySet()
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

    public void pathExistBetween(T v1, T v2) {
        if (!adjListMap.containsKey(v1)) {
            System.out.println("Vertex v1 : " + v1 + " doesn't exists.");
        }
        if (!adjListMap.containsKey(v2)) {
            System.out.println("Vertex v2 : " + v2 + " doesn't exists.");
        }
        for (Edge<T> eInV1 : adjListMap.get(v1)) {

        }
    }

    // public Graph<T> getPathFrom(T v1, T v2) {
    // public Graph<T> getPathFrom(T v1, T v2) {
    // public LinkedList<Edge<T>> getPathFrom(T v1, T v2) {
    //     if (!adjListMap.containsKey(v1)) {
    //         System.out.println("Vertex v1 : " + v1 + " doesn't exists.");
    //     }
    //     if (!adjListMap.containsKey(v2)) {
    //         System.out.println("Vertex v2 : " + v2 + " doesn't exists.");
    //     }
    //     if (v1 == v2) {
    //         // return getPathFrom(v1, v2);
    //     }
    //     // if
    //     for (Edge<T> eInV1 : adjListMap.get(v1)) {
    //         if (eInV1.dst == v2) {
    //             // return getPathFrom(v1, v2)
    //         }
    //     }
    //     // System.out.println("no");
    //     // return getPathFrom(adjListMap.get(v1).)
    // }


    // @Override
    // public Graph<T> mstKruskal() {
    //     List<Edge<T>> allEdges = getAllEdges();
    //     List<Edge<T>> sortedEdges = allEdges.stream().sorted(new Comparator<Edge<T>>() {
    //         @Override
    //         public int compare(Edge<T> e1, Edge<T> e2) {
    //             // return (e1.weight > e2.weight) ? 1 : 0;
    //             return e1.weight - e2.weight;
    //         }
    //     }).toList();
    //     System.out.println("sorted edges by weight");
    //     for (Edge<T> e : sortedEdges) {
    //         // System.out.printf("edge : %s\n", e);
    //         System.out.printf("edge : %s", e);
    //         // if (e.dst ==) {

    //         // }
    //     }
    //     return (null);
    // }
}
