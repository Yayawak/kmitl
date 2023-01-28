// import a.*;

public class Lab2Driver {
    static Lab3Coder keng;
    static Lab3Coder somsri;
    public static void main(String[] args) {
        q2_properConstructor();
    }

    static void q2_properConstructor() {
        somsri = new Lab3Coder("Somsri", 5);
        somsri.setLanguages("javascript", "dart");
        System.out.println(somsri.getLanguages());
    }
}
