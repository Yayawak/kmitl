package CS.LabW2.numberSystem.App.Converters;

import java.util.ArrayList;

public class Dec2AnyBase {

    public static String toNewBaseNumber(int initDec, int base){
        // initDec = 348
        ArrayList<int[]> arrList = new ArrayList<int []>();
        int curRem;
        int curDec = initDec;

        // todo : Successive Division
        while (true) {
            curRem = curDec % base;

            // System.out.printf("curRem = %d\n, curDec = %d\n, curQuotient = %d\n",
            //     curRem, curDec, curQuotient);
            // System.out.println("===============");

            int DiviendAndRemainder[] = { curDec, curRem };
            //* : reverse order of newBaseNumber (for good information not data)
            arrList.add(0, DiviendAndRemainder);
            
            if( curDec < base ) break;

            curDec /= base;
        }

        String newBaseNumber = "";
        for (int i=0; i<arrList.size(); i++) {
            newBaseNumber += String.valueOf(arrList.get(i)[1]);
        }

        // System.out.println(newBaseNumber);
        return newBaseNumber;
    }
}
