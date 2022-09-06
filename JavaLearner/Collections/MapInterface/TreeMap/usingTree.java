package JavaLearner.Collections.MapInterface.TreeMap;

import java.util.Iterator;
// import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class usingTree {
    public static void main(String[] args) {
        TreeMap<String, Integer> priorityAnimalTree = new TreeMap<>();
        priorityAnimalTree.put("shark", 100);
        priorityAnimalTree.put("dog", 0);
        priorityAnimalTree.put("cat", 50);
        priorityAnimalTree.put("tul", 10000);

        Set<Entry<String, Integer>> set = priorityAnimalTree.entrySet();
        Iterator<Entry<String, Integer>> iter = set.iterator();

        while (iter.hasNext()) {
            // Map.Entry me = (Map.Entry) iter.next();
            // System.out.print("key = " + me.getKey() + " , ");
            // System.out.println("value = " + me.getValue());

            // System.out.print(iter.next().toString());
        }
        // System.out.println(priorityAnimalTree.descendingKeySet());

    }
}
