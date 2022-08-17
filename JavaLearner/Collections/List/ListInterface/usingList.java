package JavaLearner.Collections.List.ListInterface;

import java.util.ArrayList;
import java.util.List;

public class usingList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        String[] goodMemory = "m1,m2,m3,m6,m5,m4".split(",");
        for (String str:goodMemory) {
            list.add(str);
            System.out.println(list);
        }
        list.notify();
    }
}
