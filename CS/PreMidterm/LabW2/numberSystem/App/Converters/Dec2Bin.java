package CS.LabW2.numberSystem.App.Converters;

import java.util.ArrayList;

public class Dec2Bin {
    int base = 2;
    public Dec2Bin(){
    }
    public String toBinary(int initDec){
        // initDec = 348
        ArrayList<int[]> arrList = new ArrayList<int []>();
        int curRem;
        int curDec = initDec;
        // int curQuotient;

        // todo : Successive Division
        while (true) {
            curRem = curDec % this.base;
            // curQuotient = curDec / this.base;

            // System.out.printf("curRem = %d\n, curDec = %d\n, curQuotient = %d\n",
            //     curRem, curDec, curQuotient);
            // System.out.println("===============");

            int DiviendAndRemainder[] = { curDec, curRem };
            //* : reverse order of binary (for good information not data)
            arrList.add(0, DiviendAndRemainder);
            
            if( curDec < this.base ) break;

            curDec /= this.base;
        }

        String binary = "";
        for (int i=0; i<arrList.size(); i++) {
            binary += String.valueOf(arrList.get(i)[1]);
        }

        System.out.println(binary);
        return binary;
    }
}
