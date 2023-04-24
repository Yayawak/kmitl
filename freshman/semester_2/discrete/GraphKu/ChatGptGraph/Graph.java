package ChatGptGraph;

import java.util.LinkedList;

public class Graph<T> {
    private T V;
    private LinkedList<T>[] adj;
    // private LinkedList<T>[] adj = new LinkedList[];

    public Graph(T v) {
        V = v;
        // adj = (LinkedList<T>[])
            // new LinkedList<?>()[(int)v];
    }
}
