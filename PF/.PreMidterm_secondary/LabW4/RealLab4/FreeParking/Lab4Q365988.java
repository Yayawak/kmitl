// package PF.LabW5.FreeParking;
package PF.LabW4.RealLab4.FreeParking;

public class Lab4Q365988 {
    public static void main(String[] args) {
        float amountCharge = 0;
        int hrsPark = 0;
        int[] xx = {2,3,4,5,20,22,123};
        // for (int i=0; i<args.length; i++) {
        for (int i=0; i<xx.length; i++) {
            hrsPark = xx[i];
            // hrsPark = Integer.parseInt(args[i]);
            // todo : my code

            // System.out.println(getRemainHrsIfNotOneDay(hrsPark));
            amountCharge = getChargeFromHrs(hrsPark);
            System.out.printf("%d hour(s) : %.2f $\n", hrsPark, amountCharge );
        }
    }

    static float oneDayLogic(int hrs){
        float charge = 0f;
        int countHr = 0;
        if (hrs >= 18) {
            charge = 24;
            return charge;
        }

        if(hrs<=0) charge = 0f;
        else if (hrs<=2) {
            charge = 4f;
            countHr = 2;
            return charge;
        }else if(hrs==3) {
            charge = 4+3;
            countHr = 3;
            return charge;
        }else if(hrs==4){
            charge = 4+3+3;
            countHr = 4;
            return charge;
        }else if(hrs>4){
            charge = 10 + 1;
            countHr = 5;
            while (countHr < hrs) {
                countHr++;
                charge++;
            }
        }
        // else if(hrs >= 18) {
        //     charge = 24;
        //     // break;
        // }
        return charge;
    }
    static float getChargeFromHrs(int hrs){
        int remDay = getQuotientDaysIfNotOneDay(hrs);
        int remHr = getRemainderHrsIfNotOneDay(hrs);

        // System.out.println();
        // System.out.println("Remain day : " + remDay);

        // ? One day
        if (remDay == 0) {
            return oneDayLogic(hrs);
        }
        // ? More than 1 days
        else {
            float charge = 0;
            charge += remDay*24f;
            charge += oneDayLogic(remHr);
            // return remDay * 24f;
            return charge;
        }


    }
    // static float filterChargeFromDay(int hrs) {
    // * Return q from int / int (not quotient)
    static int getQuotientDaysIfNotOneDay(int hrs) {
        return hrs/24;
    }
    static int getRemainderHrsIfNotOneDay(int hrs) {
        return hrs % 24;
    }
}
