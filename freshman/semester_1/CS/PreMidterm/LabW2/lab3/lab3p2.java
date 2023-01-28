package CS.LabW2.lab3;

import java.util.Arrays;

class lab3p2{
    public static void main(String[] args) {
        int size = 29;
        int[] arr = new int[size];
        int initVal = 9;
        for (int i=0; i<size; i++) {
            int currentVal;
            currentVal = initVal * i;
            if (currentVal < 200 ) {
                arr[i] = currentVal;
                continue;
            }else{
                break;
            // System.out.println(currentVal);
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}