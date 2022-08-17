package JavaLearner.Collections.MapInterface;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class usingMap {
    public static void main(String[] args) {
        Map<String, Integer> brightnessOfLamps = new HashMap<>();

        // brightnessOfLamps.put("A");
        // String[] arr = {"A", "B", "C"};
        String[] arr = "A, B, C, D, E, F".split(",");
        for (String key:arr) {
            brightnessOfLamps.put(key, (int)(Math.random() * 100));
        }

        Iterator<String> keyIter = brightnessOfLamps.keySet().iterator();
        while(keyIter.hasNext()){
            String key = (String)keyIter.next();
            Integer val = brightnessOfLamps.get(key);
            System.out.printf("key = %s, value = %d\n", key, val);
        }
    brightnessOfLamps.clear();
    System.out.println("brightness of lamps : " + brightnessOfLamps.toString());
    }
}
