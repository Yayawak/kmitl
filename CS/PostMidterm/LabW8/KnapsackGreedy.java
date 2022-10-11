// package CS.PostMidterm.LabW8;
import java.util.Arrays;
public class KnapsackGreedy{
    public static void main(String[]args) {
        // char[] labels = { 'a', 'b', 'c', 'd' };
        int[] values = { 20, 30, 50, 10 };
        int[] weights = { 2, 5, 10, 5 };
        double[] perW = new double[values.length];
        boolean[] isPicked = new boolean[values.length];
        int C = 16;
        int sumV = 0;
        int sumW = 0;
        //default value of boolean array is "false"
        System.out.println(Arrays.toString(isPicked));
        for (int i = 0; i < values.length; i++)
            perW[i] = (double) values[i] / weights[i];
        System.out.println(Arrays.toString(perW));
        int k = 0;
        // k = 0,1,2,3;
        while (k<values.length) {
            double curperW=0;
            if(perW[k]>curperW){
                curperW=perW[k];
                sumW += weights[k];
                sumV += values[k];

                if(sumW<=C){
                    isPicked[k]=true;
                }
                // if overload => delete that load // คิดผิดทีหลังก็ยัง ลบออกทัน
                else if(sumW>C){
                    sumW-=weights[k];
                    sumV -= values[k];
                    isPicked[k]=false;
                }
            }
            System.out.println("Round k:"+k+"  "+"perW :" +curperW+" "+"sumW :" +sumW);
            k++;
        }
        System.out.println(Arrays.toString(isPicked));
        System.out.println("sum value is "+ sumV + " sum weight is " + sumW);
    }
}
