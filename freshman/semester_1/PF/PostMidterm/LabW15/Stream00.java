// package LabW15;

import java.net.CookieHandler;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream00 {
    public static void main(String[] args) {
        test00();
    }

    public static void test00() {
        Integer[] scores = {99, 100,75, 80, 32};
        // int[] scores = {99, 100,75, 80, 32};
        Stream<Integer> st = Stream.of(scores);
        // st.forEach(i -> xx(i));
        // st.forEach(i -> System.out.println("X : " + i));
        // st.forEach(i -> System.out.println("X : " + i))
        // st.map(i -> i - 50)
        st.map(i -> i - 50)
            // .peek(i -> System.out.println("y " + i));
            .forEach(i -> System.out.println(i));

        // List<Integer> l = st.map(i -> i * 1.5)
        // Integer[] arr = st
            // .map(i -> i * 1.5)
            // .forEach(i -> System.out.println(i))
            // .collect(Collectors.toList());
            // .collect(Collectors.toArra());
            // .toArray(Integer[]::new);

        // List<Integer> l =  Arrays.asList(scores).stream()
        List<Double> l =  Stream.of(scores)
            .map(i -> i * 1.5)
            // .forEach(i -> System.out.println(i))
            .collect(Collectors.toList());

        // System.out.println(l.toString());


        List<Integer> sortedList = Stream.of(scores)
            .sorted((e1, e2) -> (int)(e1 - e2))
            .collect(Collectors.toList());

        System.out.println(sortedList.toString());


        System.out.println();
        // Arrays.toString(arr)
        // System.out.println(Arrays.toString(arr));
    }

    static void xx(Integer i) {
        System.out.println(i);
    }
}
