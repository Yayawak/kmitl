// package PF.LabW5.Buy2Get1;
package PF.LabW4.RealLab4.Buy2Get1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Lab4Q265988 {
    static Scanner sc = new Scanner(System.in);
    static float[] moneyArr = new float[3];
    public static void main(String[] args) {

        for(int i=0; i<3; i++) {
            float price = askPrice(i);
            insertMoneyToArray(price, i);
        }

        deleteMinPriceFromArray(moneyArr);

        System.out.println("Free min value product");
        System.out.print("Sum of products price is : ");
        float sum = 0;
        for(float x: moneyArr) {
            sum += x;
        }
        System.out.println(sum);

    }
    static float[] deleteMinPriceFromArray(float[] arr) {
        float minVal = Integer.MIN_VALUE;
        for(float curVal:arr) {
            minVal = (curVal < minVal) ? curVal : minVal;
        }
        List<Float> reductedList = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != minVal) {
                reductedList.add(arr[i]);
            }
        }
        float[] tempArr = new float[2];
        for(int i=0; i<tempArr.length; i++) {
            tempArr[i] = reductedList.get(i);
        }
        return tempArr;
    }
    private static float askPrice(int i){

        String str = "Enter price of your %d item : ";
        System.out.printf(str, i+1);

        float price = sc.nextFloat();
        System.out.printf("product's price is %.2f\n\n", price);
        return price;

    }
    static void insertMoneyToArray(float price, int i){
        moneyArr[i] = price;
    }
}