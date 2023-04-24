import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Caller {
    public static void main(String[] args) {
        callExample1();
        System.out.println("->".repeat(300));
        callExample2();
    }


    static void callExample2() {
        Graph<Integer> graph = new Graph<>();
        Integer[] buildingLabels = {
            0, 1, 2,
            3, 4, 5,
            6, 7, 8
        };

        graph.addNewEdge(buildingLabels[0], buildingLabels[1]);
        graph.addNewEdge(buildingLabels[0], buildingLabels[2]);
        graph.addNewEdge(buildingLabels[0], buildingLabels[3]);
        graph.addNewEdge(buildingLabels[0], buildingLabels[0]);
        graph.addNewEdge(buildingLabels[2], buildingLabels[5]);
        graph.addNewEdge(3, 4);
        graph.addNewEdge(buildingLabels[4], buildingLabels[3]);
        graph.addNewEdge(buildingLabels[5], buildingLabels[0]);
        graph.addNewEdge(buildingLabels[5], buildingLabels[0]);

        representInDegreeAndOutDegree(graph,
            Arrays.stream(buildingLabels).iterator()
        );
    }

    static void callExample1() {
        Graph<Hero> graph;
        Hero[] heroes = {
            new Hero("muerta", 7),
            new Hero("draw ranger", 8),
            new Hero("strom spirit", 4),
            new Hero("bara", 3),
            new Hero("clinkz", 6),
        };
        graph = new Graph<>();

        graph.addNewEdge(heroes[0], heroes[1]);
        graph.addNewEdge(heroes[0], heroes[4]);
        graph.addNewEdge(heroes[0], heroes[0]);
        graph.addNewEdge(heroes[2], heroes[2]);
        graph.addNewEdge(heroes[3], heroes[0]);
        graph.addNewEdge(heroes[4], heroes[3]);

        representInDegreeAndOutDegree(graph,
            Arrays.stream(heroes).iterator()
        );
    }

    static <T> void representInDegreeAndOutDegree(Graph<T> graph,
        Iterator<T> iter) {
        System.out.println(graph.toString());
        while (iter.hasNext()) { T element = iter.next();
            System.out.println("Vertex : " + element);
            // System.out.format("in degree of %s : %d\n",
            System.out.format("in degree : %d\n",
                graph.inDegreeOfVertex(element)
            );
            // System.out.format("out degree of %s : %d\n",
            System.out.format("out degree : %d\n",
                graph.outDegreeOfVertex(element)
            );
            // System.out.println("\n" + "=+".repeat(50) + "\n");
            System.out.println("=+".repeat(50));
        }
    }
}
