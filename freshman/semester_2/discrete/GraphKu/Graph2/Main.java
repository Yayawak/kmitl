package Graph2;

import java.util.Arrays;

class Hero {
    String name;
    int attackDamage;
    public Hero(String name, int attackDamage) {
        this.name = name;
        this.attackDamage = attackDamage;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAttackDamage() {
        return attackDamage;
    }
    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
}
public class Main {
    public static void main(String[] args) {
        Hero[] heroes = {
            new Hero("muerta", 7),
            new Hero("draw ranger", 8),
            new Hero("strom spirit", 4),
            new Hero("bara", 3),
            new Hero("clinkz", 6),
    };
        Graph<Hero, String> graph = new Graph<>(false, false);
        // graph.addVertex(null);
        Arrays.asList(heroes).stream()
            .forEach(graph::addVertex);

        System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkk");
        graph.addEdge(heroes[0], heroes[1]);
        graph.addEdge(heroes[0], heroes[4]);
        graph.addEdge(heroes[2], heroes[2]);
        graph.addEdge(heroes[4], heroes[3]);
        graph.addEdge(heroes[3], heroes[0]);
        // graph.addVertex();

        graph.depthFirstTraversal(new Vertex<Hero>(heroes[0]));
    }
}
