import packA.*;
import java.util.ArrayList;

public class Lab2Inheritance {
    public static void main(String[] args) {
        q1();
    }
    static void q1() {
        ArrayList<EmpTmp> aList = new ArrayList<>();
        aList.add(new Accountant("GoodAtmyJob", 7, 6, 390, "sing"));
        aList.add(new Accountant("canRap", 4, 9 ,480, "rap"));
        aList.add(new Salesperson("mr.salesperson", 5, 150, 5000));
        aList.add(new Salesperson("mr.kayan", 3, 260, 9000));
        aList.add(new Programmer("Keng", 2, 3000));
        aList.add(new EmpTmp("invisible", 9, 120));

        System.out.println("Upcasting");
        for (EmpTmp e : aList) {
            e.sayHi();
        }

        System.out.println("Downcasting");
        for (EmpTmp e : aList) {
            String str;
            if (e instanceof Programmer) {
            // if (e instanceof Programmer) {
                Programmer p = (Programmer)e;
                p.coding();
            }
            else if (e instanceof Salesperson) {
                Salesperson sp = (Salesperson)e;
                sp.makeQuotation();
            }
            else if (e instanceof Accountant) {
                Accountant accbar = (Accountant)e;
                accbar.tellProfit();
            }
            else {
                // nothing to do
            }
            str = e.toString();

            System.out.println(str);
        }
    }
}
