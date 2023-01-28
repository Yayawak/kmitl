import java.util.ArrayList;

import javax.crypto.KeyGenerator;

public class Lab3Driver {
    static Lab3Coder keng;
    static Lab3Coder somsri;
    public static void main(String[] args) {
        q2();
        q3();
    }

    static void q2() {
        somsri = new Lab3Coder("Somsri", 5);
        somsri.setLanguages("javascript", "dart");
        // somsri.setLanguages("javascript", "dart", "java");
    }

    static void q3() {
        // todo 1
        keng = new Lab3Coder("Keng", 2);
        keng.setLanguages("java", "solidity", "c");

        Lab3Coder ber3 = new Lab3Coder("ber3");
        ber3.setLanguages("c", "java", "typescript");

        System.out.println(ber3);
        System.out.println();

        // todo 2
        // System.out.println(keng.getLanguages());
        ArrayList<String> commonLanguages = ber3.findCommonLanguage(somsri);
        System.out.println(commonLanguages);

        System.out.println(keng.findCommonLanguage(ber3));
    }
}
