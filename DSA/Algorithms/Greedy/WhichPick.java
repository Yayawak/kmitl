import java.util.Arrays;

import apple.laf.JRSUIConstants.Widget;

class WhichPick{
    public static void main(String[] args) {
        char[] labels = {'a', 'b', 'c', 'd'};
        int[] vals = {20, 30, 50, 10};
        int[] weights = {2, 5, 10, 5};

        double[] perW = new double[vals.length];
        boolean[] isPicked = new boolean[vals.length];
        int C = 16, sumV=0, sumW=0;

        // System.out.println(Arrays.toString(isPicked));
        for (int i=0; i<vals.length; i++) {
            perW[i] = (double)vals[i] / weights[i];
        }
        int k = 0;
        // System.out.println(Arrays.toString(perW));
        // selected a:2, b:5, d:5
        while (C>0) {
        // while (k<4) {

            // if C -= ? it's mean you select that item
            // todo 1 : curRatioMax : p_max
            // int
            double curRatioMax = Integer.MIN_VALUE;
            int crmIdx = 0;
            // todo 4 : sub array of selected item
            for(int i=0; i<perW.length; i++) {
                if(perW[i] > curRatioMax) {
                    curRatioMax = perW[i];
                    crmIdx = i;
                    perW[i] = Integer.MIN_VALUE;
                }else {
                    // crmIdx = -1;
                }
            }
            System.out.printf("crmIdx = %d\n", crmIdx);
            System.out.println(Arrays.toString(perW));

            // todo 2 : is prevSumW + curW > C ?
            if(sumW + weights[crmIdx] <= C) {
                sumW += weights[crmIdx];
                sumV += vals[crmIdx];
                // todo 3 : select which item will be used;
                C -= weights[crmIdx];
                isPicked[crmIdx] = true;
            }else{
                C = 0;
                // continue;
                // break;
            }
            // System.out.printf("C = %d\n", C);
            // System.out.println();
            System.out.println(Arrays.toString(isPicked));
            // if (C == 0) break;
            // System.out.println(sumW);
            // if(weights[k] <= C) {
            //     sumV += vals[k];
            //     sumW += weights[k];
            //     C -= weights[k];
            // }else {
            //     sumV += vals[k] * (double)C/weights[k];
            //     C = 0;
            //     break;
            // }
            // System.out.println(Arrays.toString(vals));
            k++;
        }
        // System.out.println("Sum V is " + sumV);
        // System.out.println("Sum W is " + sumW);
    }
}
