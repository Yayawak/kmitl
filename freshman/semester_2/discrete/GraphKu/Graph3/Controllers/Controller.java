package Graph3.Controllers;

import Graph3.Models.Graph;
import Graph3.Models.Hero;
import Graph3.Models.Model;

public class Controller {
    private Hero[] heroes = Model.getHeroes();
    private Graph<Hero> graph;
    private static Controller instance;

    public static Controller getInstance() {
        if (instance == null) instance = new Controller();
        return instance;
    }

    public Controller() {
        graph = new Graph<>();

        graph.addNewEdge(heroes[0], heroes[1]);
        graph.addNewEdge(heroes[0], heroes[4]);
        graph.addNewEdge(heroes[2], heroes[2]);
        graph.addNewEdge(heroes[4], heroes[3]);
        // graph.addNewEdge(heroes[3], heroes[0]);
        // graph.addNewEdge(heroes[0], heroes[0]);

    }

    public Graph<Hero> getGraph() {
        return graph;
    }

    public Hero getHero() {
        return heroes[0];
    }

    public Hero[] getHeroes() {
        return heroes;
    }
}
