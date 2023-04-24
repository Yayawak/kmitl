package MyGraph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashMap<Vertex<String>, ArrayList<Vertex<String>>> hm = new HashMap<>();
        // Vertex v1 = new V
        // Vertex<Flight> vertices = {
        //     new Vertex<Flight>(new Flight("berlin", "liberio")),
        //     new Vertex<Flight>(new Flight("bangkok", "beijing")),
        //     new Vertex<Flight>(new Flight("rio de janairo", "kurgnigs brug")),
        //     new Vertex<Flight>(new Flight("vienna", "new york")),
        // };
        List<Vertex<String>> cities = new ArrayList<>(
            Arrays.asList("berlin", "liberio", "rio", "new york", "kurgnigs burg", "vienna")
            .stream().map(Vertex::new).toList()
        );
        cities.stream().map(Vertex::getData)
            .forEach(System.out::println);

        cities.get(0).setAdjacentVertices(
            cities
        );
        // cities.get(0).setAdjacentVertices(
            // cities.get(1), cities.get(3)
        // );
    }
}
