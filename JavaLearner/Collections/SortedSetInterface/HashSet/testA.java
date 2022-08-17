package JavaLearner.Collections.SortedSetInterface.HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class testA {
    public static void main(String[] args) {
        String characters = "will,john,elio,eleven,bob,nix";
        HashSet<String> hs = new HashSet<>(); 

        // ! Repeat 20 times
        for (String str: characters.repeat(20).split(",")){
            hs.add(str);
        }

        Iterator<String> iter = hs.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next().toString());
        }
    }
}
