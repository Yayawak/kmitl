package JavaLearner.Collections.SortedSetInterface.BasicSortedSet;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class priorityOrdering {
    public static void main(String[] args) {
        SortedSet<String> set = new TreeSet<>();
        String[] arr = "America, China, Russia, India, England, France".split(", ");
        for (String str:arr) {
            // ! Order does matters. !!!!
            set.add(str);
        }
        // System.out.println(set);

        Iterator<String> iter = set.iterator();
        while(iter.hasNext()) {
            String item = iter.next().toString();
            System.out.println(item);
            // JOptionPane.showOptionDialog(null, item)
            String msg = "Element : " + item + " \t| priority : " + iter.next().hashCode();
            JOptionPane.showMessageDialog(null, msg);
        }
    }
}
