import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class KruskalMst<T> {
    private WeighedGraph<T> graph;

    public KruskalMst(WeighedGraph<T> g) {
        this.graph = g;
    }

    // public List<Edge
    public List<WeighedGraph.Edge<T>> getMst() {
        List<WeighedGraph.Edge<T>> allEdges = graph.getAllEdges();
        Collections.sort(allEdges);

        Map<T, T> parent = new HashMap<>();
        List<WeighedGraph.Edge<T>> mstEdges = new ArrayList<>();

        for (T vertex : graph.getAllVertices()) {
            parent.put(vertex, vertex);
        }

        for (WeighedGraph.Edge<T> edge : allEdges) {
            T src = find(edge.src, parent);
            T dst = find(edge.dst, parent);

            if (!src.equals(dst)) {
                mstEdges.add(edge);
                parent.put(src, dst);
            }
        }
        return mstEdges;
    }

    private T find(T vertex, Map<T, T> parent) {
        if (parent.get(vertex).equals(vertex)) {
            return (vertex);
        }
        return find(parent.get(vertex), parent);
    }

}
