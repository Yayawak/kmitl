package BasicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static void demo1() {
        System.out.println("-demo1---");
        SillyLuckyNumber [] arr = {
            new SillyLuckyNumber("Terrier"), new SillyLuckyNumber("Jack"),
            new SillyLuckyNumber("Pom"), new SillyLuckyNumber("Beagle")
        };
        System.out.println(Arrays.toString(arr));
        // Comparator<SillyLuckyNumber> engine = new Comparator<>() {
        // @Override
        // public int compare(SillyLuckyNumber o1, SillyLuckyNumber o2) {
        // return Integer.compare(o1.getLuckyNumer(), o2.getLuckyNumer());
        // }
        // };
        // Integer.compare(0, 0)

        // Comparator<SillyLuckyNumber> engine = //your code (sort by luckyNumber);
        Comparator<SillyLuckyNumber> engine = 
        (sln1, sln2) -> {
            // return (sln1.getLuckyNumber() - sln2.getLuckyNumber());
            // return (Integer.compare(sln1.getLuckyNumber(), sln2.getLuckyNumber()));
            return (Integer.compare(sln2.getLuckyNumber(), sln2.getLuckyNumber()));
        };

        Arrays.sort(arr, engine);
        System.out.println(Arrays.toString(arr));
    }
    static void demo2() {
        System.out.println("-demo2----");
        ArrayList<SillyLuckyNumber> list = new ArrayList<>(Arrays.asList(
                new SillyLuckyNumber("Terrier"), new SillyLuckyNumber("Jack"),
                new SillyLuckyNumber("Pom"), new SillyLuckyNumber("Beagle")));
        System.out.println(list);
        // Collections.sort(list,
        //     (sln1, sln2) -> {
        //         return (Integer.compare(sln1.getLuckyNumber(), sln2.getLuckyNumber()));
        //     }
        // );
        Collections.sort(
            list, 
            Comparator.comparing(SillyLuckyNumber::getLuckyNumber)
        );
        System.out.println(list);
    }

    static void demo3() {
        System.out.println("-demo3----");
        ArrayList<SillyLuckyNumber> list = new ArrayList<>(Arrays.asList(
                new SillyLuckyNumber("Terrier"), new SillyLuckyNumber("Jack"),
                new SillyLuckyNumber("Pom"), new SillyLuckyNumber("Beagle")));
        System.out.println(list);
        list.sort(Comparator.comparing(SillyLuckyNumber::getLuckyNumber));
        System.out.println(list);
        // demo shallow copy
        ArrayList<SillyLuckyNumber> anotherList = new ArrayList<>(list.subList(0, list.size()));
        anotherList.get(0).setBreed("newBreed"); // Terrier
        System.out.println(list); // notice how Terrier in list is also effected
    }

    static void ex0() {
        System.out.println("--ex0-----");
        int[] arr = { 7, 3, 1, 9, 6, 8, 4, 2, 5 };
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        // ex0();
        // demo1();
        // demo2();
        demo3();
    }
}
