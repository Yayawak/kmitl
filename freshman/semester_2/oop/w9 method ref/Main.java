import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

interface HalfValueInterface {
    public void printHalf(int n);
}

class NumberProcess {
    public void printHalf(int n) {
        System.out.println(n / 2);
    }
}

class Singer implements Comparable<Singer> {
    String name;
    String style;
    public Singer(String name, String style) {
        this.name = name;
        this.style = style;
    }
    public String getStyle() {
        return style;
    }
    public void setStyle(String style) {
        this.style = style;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Singer [name=" + name + ", style=" + style + "]";
    }

    @Override
    public int compareTo(Singer o) {
            return this.name.compareTo(o.name);
    }
}

public class Main {
    static List<Singer> singerList = new ArrayList<>(
        Arrays.asList(
            new Singer("tayler series", "rock"),
            new Singer("euler", "very pop"),
            new Singer("bernouli", "punk")
        )
    );
    static void printStyle(String topic, int repeat) {
        System.out.println("<-".repeat(repeat) + " "
        + topic
        + "->".repeat(repeat)
        + "\n"
        );
    }
    public static void main(String[] args) {
        q1_halfEachNumber();
        q2_forEachSingerName();
        q3_lambda_comparator();
        q4_method_ref_comparator();
    }

    static void q1_halfEachNumber() {
        List<Integer> nums = Arrays.asList(100, 105, 203);

        printStyle("† lambda § fn interface", 4);
        HalfValueInterface halfVal = n -> System.out.println(n / 2);
        for (int n : nums)
            halfVal.printHalf(n);

        printStyle("© Consumer x for loop ©", 4);
        Consumer<Integer> consumer = n -> System.out.println(n / 2);
        for (int n : nums)
            consumer.accept(n);

        printStyle("© Consumer : for each ©", 4);
        Consumer<Integer> halfMe = n -> System.out.println(n / 2);
        nums.stream().forEach(halfMe::accept);
        // nums.stream().map(halfMe::accept);

        printStyle("œ lambda consumer", 4);
        nums.forEach(n -> System.out.println(n / 2));

        printStyle("¥ NumberProcess method ref", 4);
        NumberProcess np = new NumberProcess();
        nums.forEach(np::printHalf);
    }

    static void q2_forEachSingerName() {
        singerList.stream().map(singer -> singer.getName())
            .forEach(System.out::println);
        singerList.stream().map(Singer::getName)
            .forEach(System.out::println);
    }

    static void q3_lambda_comparator() {
        printStyle("annonymous class comparator", 4);
        Comparator<Singer> byStyle1 =
            new Comparator<>() {
            @Override
            public int compare(Singer o1, Singer o2) {
                return o1.getStyle().compareTo(o2.getStyle());
            };
        };
        Collections.sort(singerList, byStyle1);
        singerList.forEach(System.out::println);


        printStyle("lambda comparator", 4);
        Comparator<Singer> byName = (s1, s2) ->
            s1.getName().compareTo(s2.getName());
        Collections.sort(singerList, byName);
        // Collections.sort(singerList, new Comparator<Singer>() {
        //     @Override
        //     public int compare(Singer o1, Singer o2) {
        //         return o1.getName().compareTo(o2.getName());
        //     }
        // });
        singerList.forEach(System.out::println);
    }

    static void q4_method_ref_comparator() {
        printStyle("∑ Comparator.comparing() ß", 4);
        Comparator<Singer> byName = Comparator.comparing(Singer::getName);
        Collections.sort(singerList, byName);
        singerList.forEach(System.out::println);

        singerList.sort(Comparator.comparing(
            Singer::getStyle
        ));
        // singerList.stream().sorted()
        printStyle("¢ Compare inline", 4);
        singerList.forEach(System.out::println);

        printStyle("¢ Compare real inline", 4);
        singerList.forEach(System.out::println);
        singerList.stream().sorted(Comparator
            .comparing(Singer::getStyle))
            .forEach(System.out::println);
    }
}
