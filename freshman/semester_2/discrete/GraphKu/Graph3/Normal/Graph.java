
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph<T> {
    private Map<T, ArrayList<T>> map = new HashMap<>();

    public void addNewVertex(T s) {
        map.putIfAbsent(s, new ArrayList<T>());
    }

    public void addNewEdge(T v1, T v2) {
        if (!map.containsKey(v1))
            addNewVertex(v1);
        if (!map.containsKey(v2))
            addNewVertex(v2);
        map.get(v1).add(v2);
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
        builder.append("\nGraph representation by Adjacency List\n");
        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (T u : map.get(v)) {
                builder.append(u.toString() + "   -->   ");
            }
            builder.append("\n");
            builder.append(">-".repeat(20));
            builder.append("\n");
        }
        return (builder.toString());
    }

    public int outDegreeOfVertex(T v) {
        if (!map.containsKey(v)) return 0;
        return map.get(v).size();
    }

    public int inDegreeOfVertex(T v) {
        if (!map.containsKey(v)) return 0;
        int counter = 0;
        for (T u : map.keySet()) {
            // System.out.println("u = " + u);
            // System.out.println("content of u = " + map.get(u));
            if (map.get(u).contains(v))
                counter++;
        }
        return counter;
    }
}
