package JavaLearner.Collections.List.ArrayList;

import java.util.ArrayList;

public class usingAL {
    public static void main(String[] args) {
        String countries = "Thai, America, Belgium, Italy, Spain";
        String[] arr = countries.split(",");    

        ArrayList<String> arrList = new ArrayList<>();
        
        for (String a:arr) {
            arrList.add(a);
        }
        System.out.print(arrList);
        System.out.println(arrList.get(0));
        
        // System.out.println(countries.repeat(3));
    }
}
