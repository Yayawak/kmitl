package Test;

public class Character implements CanMove {
    private float moveSpeed;
    private String name;
    // ! nested class
    public class Pet {
        private String petName;
    }
    private Pet petOfCharacter;

    public static void main(String[] args) {

    }

    @Override
    public void move(int speed) {
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
}
