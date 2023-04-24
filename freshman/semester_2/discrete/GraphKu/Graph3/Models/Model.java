package Graph3.Models;

public class Model {
    private static Hero[] heroes = {
            new Hero("muerta", 7),
            new Hero("draw ranger", 8),
            new Hero("strom spirit", 4),
            new Hero("bara", 3),
            new Hero("clinkz", 6),
    };

    public static Hero[] getHeroes() {
        return heroes;
    }
}
