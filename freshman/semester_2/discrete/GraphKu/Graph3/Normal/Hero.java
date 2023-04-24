
public class Hero {
    private String name;
    private int attackDamage;
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
    @Override
    public String toString() {
        // return "Hero[name=" + name + ", attackDamage=" + attackDamage + "]";
        // return "Hero's name = " + name;
        return name;
    }
}
