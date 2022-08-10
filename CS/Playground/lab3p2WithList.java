package CS.Playground;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class lab3p2WithList {
    public static void main(String[] args)  {
        int initVal = 9;         

        List<Integer> list = new ArrayList<Integer>();
        // int elements = new Random().nextInt(100);
        for (int i=0; i< 100; i++) {
            int currentVal;
            currentVal = initVal * i;
            if (currentVal < 200 ) {
                // list.add(new Random().nextInt(100));
                list.add(currentVal);
                continue;
            }else{
                break;
            }
        }
        System.out.println(list.toString());
    }
}
