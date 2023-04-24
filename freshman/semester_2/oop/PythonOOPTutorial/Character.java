public class Character {
    String name;
    int velocity;
    public Character(String name, int velocity) {
        this.name = name;
        this.velocity = velocity;
    }
}

class Pet extends Character {

    public Pet(String name, int velocity) {
        super(name, velocity);
    }

}
