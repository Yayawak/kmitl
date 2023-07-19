package Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.sql.CommonDataSource;

public class MainMain {
    public static void main(String[] args) {
        // ! 1. concrete class
        CanMove character = new Character();

        // ! 2. anonymouse class
        CanMove dog = new CanMove() {
            @Override
            public void move(int speed) {
                System.out.println("move" + speed);
            }
        };

        // ! 3. lambda
        CanMove cat = (int speed) -> {
            System.out.println("move");
        };

        List<String> colleges = new ArrayList<>();
        colleges.add("kmitl");
        colleges.add("kmitlllll");
        colleges.add("cmu");
        colleges.add("tu");
        colleges.add("ku");
        colleges.add("vu");
        colleges.add("gu");

        // ! lambda
        colleges.stream().map((col) -> col.toUpperCase());
        List<String> collegeUpper =
        colleges.stream()
            .map((col) -> col.toUpperCase())
            // .sorted(new Comparator<String>() {
            //     @Override
            //     public int compare(String o1, String o2) {
            //         return o2.compareTo(o1);
            //     };
            // }).toList();
            .sorted((c1, c2) -> {
                    if (c1.length() < c2.length()) {
                        return -1;
                    }
                    else {
                        return +1;
                    }
                }
            )
            .toList();
        System.out.println(collegeUpper);
        // Collections.sort
        // comparatorDemo();
    }

    public static void comparatorDemo() {
        // 1 < 2, 5 < 10
        // "Dumbledor" > "Hedwig"
        // System.out.println("Dumb".compareTo("Hed"));
    }
}
