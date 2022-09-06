package JavaLearner.Collections.Vector;

// import java.lang.reflect.Array;
import java.util.Arrays;
// import java.util.Enumeration;
import java.util.Vector;

public class BasicVector {
    public static void main(String[] args) {
        Vector<String> dayNames = new Vector<>();
        String[] arr = "Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday".toUpperCase().split(",");
        dayNames.addAll(Arrays.asList(arr));

        // Enumeration<String> days = dayNames.elements();
        int i = 0;
        // while (days.hasMoreElements()) {
        while (i < dayNames.size()) {

            // !! ACCESS ELEMENTS BY INDEXING
            System.out.println(dayNames.get(i));
            i ++;
            // System.out.println("Days element = " + days.nextElement());
        }
        System.out.println("====================");
        // System.out.println(dayNames);
    }
}
