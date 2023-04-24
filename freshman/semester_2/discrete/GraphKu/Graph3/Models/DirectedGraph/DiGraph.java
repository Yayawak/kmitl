package Graph3.Models.DirectedGraph;

import java.util.ArrayList;
import java.util.List;

import Graph2.Graph;


public class DiGraph<T> {
    List<List<T>> adjList = new ArrayList<>();

    public DiGraph(List<Edge<T>> edges) {
        int n = edges.size();
        // reserve space for adjList
        // for (int i = 0; i < n; i++) {
        //     adjList.add(i, new ArrayList<T>());
        // }
        // // add the edges to the undirected graph
        // for (int i = 0; i < edges.size(); i++) {
        //     // allocate new node
        //     adjList.get(i).add(edges.get(i).d);
        // }
    }

    public void showGraph() {
        int i = 0;
        int n = adjList.size();
        System.out.println("Adjacent list of the graph is : ");
        while (i < n) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.format("%s --> %s,\t ",
                    adjList.get(i),
                    adjList.get(i).get(j)
                );
                System.out.println("\n" + "->".repeat(20));
            }
            i++;
        }
    }
}
