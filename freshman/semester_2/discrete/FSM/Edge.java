// public static class Edge<T> implements Comparable<Edge<T>> {
public class Edge<T> implements Comparable<Edge<T>> {
    // T src;
    // T dst;
    Vertex<T> src;
    Vertex<T> dst;
    int weight;


    public Edge(Vertex<T> src, Vertex<T> dst, int weight) {
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
    public int compareTo(Edge<T> o) {
        return weight - o.weight;
    }
}
