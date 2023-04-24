package LearnUsing;

import java.net.Socket;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import javax.tools.ToolProvider;

public class Main {
    // List<String> personName = new ArrayList<>();
    // static String[] A = {"ludwig", "betthaw", "kraken"};
    // static List<String> personName = Arrays.asList(A);
    // static Person[] persons = {
    static ArrayList<Person> people = new ArrayList<Person>
    (
        Arrays.asList(
            new Person("ludwig", 18, "Latte", 3),
            new Person("kayawin", 18, "Espresso", 5),
            new Person("drehar", 18, "Dark choc", 1),
            new Person("aueeror", 18, "Water", 0)
        )
    );
    // static Person
    public static void main(String[] args) {
        // q1();
        // q2_instanceMethod();
        q3();
    }

    // Socket
    public static void q1() {
        List<String> tmp = new ArrayList<>();
        for (Person p : people) {
            tmp.add(p.getName());
        }
        // ToolProvider
        List<String> ans1 = tmp.stream().map(
            WaysToRef::staticMethodCS
        ).collect(Collectors.toList());
        System.out.println(ans1);

        System.out.println(tmp);
        System.out.println(tmp.stream()
            .map(WaysToRef::staticMethodKmitl)
            .collect(Collectors.toList()));

    }

    static void q2_instanceMethod() {
        System.out.println(
            people.stream().map(
                new WaysToRef()::capitalizeName)
                .toList()
        );

    }

    static void q3() {
        Comparator<Person> byLotto = Comparator.comparing(
            Person::getLottoMotto
        );
        System.out.println("--------sort by lotto---------");
        // people.forEach(System.out::println);
        Collections.sort(people, byLotto);
        people.forEach(System.out::println);

        System.out.println("---------toLower case---------");
        // List<String> names = Arrays.asList("yindee", "preeda", "pramonte")
        List<String> names = people.stream()
            .map(Person::getName)
            .collect(Collectors.toList());
        List<String> ans = names.stream()
            .map(String::toUpperCase)
            .toList();
        System.out.println("original " + names);
        System.out.println("toUpper  " + ans);

        System.out.println("---------stream chain---------");
        System.out.println("chain command " +
            people.stream().map(Person::getName)
            .map(String::toUpperCase)
            .toList()
        );

        System.out.println("----------create object by list names---------------");
        // Stack
        // Queue
        // Cipher
        List<String> newNames = new ArrayList<>(
            Arrays.asList(
                "Parker",
                "Peter",
                "Voldemort",
                "James",
                "Harier"
            )
        );
        class Singer {
            String name;
            public Singer(String name) {
                this.name = name;
            }
            public String sing() {
                return String.format("Hello i'm %s, i'm sing\n",
                name);
            }
        }
        List<Singer> singers = newNames.stream()
            .map(Singer::new).toList();
        singers.stream().map(Singer::sing)
            .forEach(System.out::print);
    }

    // static void
}
