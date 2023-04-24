import pack7a.*;
// import org.fusesource.jansi.AnsiConsole;
// import org.fus

public class Test7Basket {
    public static void main(String[] args) {
        // AnsiConsole.systemInstall();
        Shop csShop = new Shop("CS-groceries");
        String picking;

        // printBreakLine(1, Colors.ANSI_YELLOW);
        printBreakLine(1);
        Basket b1 = csShop.newCustomerArrives();
        picking = "mama";
        b1.putInBasket(csShop.generateLineItem(picking, 1));
        picking = "lactasoy";
        b1.putInBasket(csShop.generateLineItem(picking, 2));
        b1.showItemsInBasket();

        Basket b2 = csShop.newCustomerArrives();
        picking = "mix veggies";
        b2.putInBasket(csShop.generateLineItem(picking, 3));
        picking = "korean";
        b2.putInBasket(csShop.generateLineItem(picking, 4));
        b2.showItemsInBasket();

        printBreakLine(2);
        csShop.getPayment(b1);
        csShop.getPayment(b2);

        printBreakLine(3);
        b2 = csShop.newCustomerArrives();
        picking = "mama";
        LineItem item = csShop.generateBuyNowItem(picking);
        // item.
        // b2.buyNow(item);
        csShop.buyNow(item, b2);
        // csShop.getPayment(b2);
        // System.out.println("kkkkk".repeat(8));
        // b2.showItemsInBasket();
        // System.out.println("kkkkk".repeat(8));

        printBreakLine(4);
        csShop.dailySalesReport();
    }

    // public static void printBreakLine(int line, String colorAnsci) {
    public static void printBreakLine(int line) {
        String colorAnsci = Colors.ANSI_GREEN;
        System.out.println(line + " " + colorAnsci + "-------------".
            repeat(3)
            + Colors.ANSI_WHITE);
        System.out.println();
    }
}
