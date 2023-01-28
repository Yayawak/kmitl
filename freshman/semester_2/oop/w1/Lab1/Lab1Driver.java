// import a.*;

public class Lab1Driver {
    public static void main(String[] args) {
        q1();
    }

    static void q1() {
        Lab2Coder santa = new Lab2Coder();
        santa.setName("Santa");
        santa.setExperience(3);
        String str = String.format(
            "%s has been working for %d years.",
            santa.getName(), santa.getExperience()
        );
        System.out.println(str);
    }
}
