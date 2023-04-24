package Tree;

class University implements Comparable<University> {
    public University(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "University [name=" + name + "]";
    }

    @Override
    public int compareTo(University u) {
        return this.name.compareTo(u.name);
    }
}
public class Caller {
    public static void main(String[] args) {
        BinaryTree<University> t = new BinaryTree<>(
            new University("CU")
        );
        t.insert(new University("cmu"));
        t.insert(new University("kmitl"));
        t.insert(new University("kmutt"));
        t.insert(new University("tu"));
        t.insert(new University("ku"));

        // BinaryTree<Integer> t = new BinaryTree<Integer>(5);
        // t.insert(5);
        // t.insert(33333);
        // t.insert(3);
        // t.insert(7);
        // t.insert(1);
        // t.insert(9);

        // // t.preorderTraverse();
        // t.inorderTraverse();


    }
}
