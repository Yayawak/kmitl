import java.util.Scanner;

public class NaiveGoldTrader {
    static void readGoldPrices(int goldPrices[], int n) {
        for (int i = 0; i < n; i++) {
            goldPrices[i] = (int) Math.round(Math.random() * 20000 + 20000);
        }
    }

    // static void readGoldPrices(int goldPrices[]) {
    static int readGoldPrices(int goldPrices[]) {
        // for (int i = 0; i < n; i++) {
        //     goldPrices[i] = (int) Math.round(Math.random() * 20000 + 20000);
        // }
        int i = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            // System.out.println(line);
            goldPrices[i] = Integer.valueOf(line);
            i++;
        }
        sc.close();
        return i;
    }


    // static void readGoldPrices(int goldPrices[])
    public static void v2(int n)
    {
        int goldPrices[] = new int[1000000];

        // System.out.println(args[0]);
        // int n = Integer.parseInt(n);
        readGoldPrices(goldPrices, n);
        // readGoldPrices(goldPrices, n);

        int bestBuyDate = 0;
        int bestSellDate = 0;
        int maxProfit = Integer.MIN_VALUE;
        long count = 0;
        for (int buyDate = 0; buyDate < n - 1; buyDate++) {
            for (int sellDate = buyDate + 1; sellDate < n; sellDate++) {
                count++;
                int profit = goldPrices[sellDate] - goldPrices[buyDate];
                if (profit > maxProfit) {
                    maxProfit = profit;
                    bestBuyDate = buyDate;
                    bestSellDate = sellDate;
                }
            }
        }
        System.out.println("Number of days: " + n);
        System.out.println("Max profit is: " + maxProfit);
        System.out.println("Buy date: " + (bestBuyDate + 1));
        System.out.println("Sell date: " + (bestSellDate + 1));
        System.out.println("count: " + count);
        System.out.println("------------------");
    }
    public static void v1()
    {
        int goldPrices[] = new int[1000000];

        // System.out.println(args[0]);
        // int n = readGoldPrices(goldPrices);
        // int n = Integer.parseInt(args[0]);
        // readGoldPrices(goldPrices, n);
        int n = readGoldPrices(goldPrices);

        // System.out.println(goldPrices[0]);
        int bestBuyDate = 0;
        int bestSellDate = 0;
        int maxProfit = Integer.MIN_VALUE;
        long count = 0;
        for (int buyDate = 0; buyDate < n - 1; buyDate++) {
            for (int sellDate = buyDate + 1; sellDate < n; sellDate++) {
                count++;
                int profit = goldPrices[sellDate] - goldPrices[buyDate];
                if (profit > maxProfit) {
                    maxProfit = profit;
                    bestBuyDate = buyDate;
                    bestSellDate = sellDate;
                }
            }
        }
        System.out.println("Number of days: " + n);
        System.out.println("Max profit is: " + maxProfit);
        System.out.println("Buy date: " + (bestBuyDate + 1));
        System.out.println("Sell date: " + (bestSellDate + 1));
        System.out.println("count: " + count);
        System.out.println("------------------");
    }


    public static void main(String args[]) {

        // v1();

        // v2(Integer.valueOf(args[0]));
        int tenthounsand = 10000;
        for (int i = 0; i < 10; i++)
        {
            v2(i * tenthounsand + tenthounsand);
        }
        v2(1000000);
    }
}
