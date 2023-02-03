import java.util.ArrayList;

// import packA.classes.*;
// import packA.classes.Ac1.*;
// import packA.classes.Ac2.*;
import packA.classes.Ac1.Lec4Duck;
import packA.classes.Ac1.Lec4Fish;

import packA.classes.Ac2.Programmer;
import packA.classes.Ac2.ProgrammerManager;

public class Main {
    public static void main(String[] args) {
        Activity1_FishDuck.init();

        System.out.println();

        Activity2_Employee.init();
    }

    class Activity1_FishDuck {
        public static void init() {
            q1();
        }

        static void q1() {
            Lec4Fish fish = new Lec4Fish();
            fish.swim();
            fish.fishMethod();

            System.out.println();

            Lec4Duck duck = new Lec4Duck();
            duck.swim();
            duck.duckMethod();
        }
    }

    static class Activity2_Employee {
        public static void init() {
            q1();
            System.out.println("--------------------------------");
            q2();
        }
        private static void q1() {
            ProgrammerManager pmanager = new ProgrammerManager(
                "CodeReviewer", 9, 550, "solidity, typescript"
            );
            System.out.println(pmanager);
            pmanager.sayHi();
        }
        private static void q2() {
            ProgrammerManager pmanager = new ProgrammerManager(
                "CodeReviewer", 9, 550, "solidity, typescript"
            );
            ArrayList<Programmer> aList = new ArrayList<>();
            aList.add(new Programmer("Keng", 2, 300));
            aList.add(new Programmer("Somsrit", 3, 400));
            aList.add(new Programmer("haha", 4, 600));
            for (Programmer p : aList) {
                int newSalary = pmanager.evaluate(p);
                System.out.println(newSalary);
            }
        }


    }

}
