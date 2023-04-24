package pack7a;

import java.util.ArrayList;

public class Shop {
    private String name;
    private Catalog catalog = new Catalog();
    private ArrayList<Basket> ordersToday = new ArrayList<>();
    // ! every shop should not share basket together or products
    // private static ArrayList<Basket> ordersToday = new ArrayList<>();

    public Shop(String n) {
        name = n;
        catalog.add(new Drink("mix veggies", "refreshing"), 22);
        catalog.add(new Drink("lactasoy", "less hungry"), 15);
        catalog.add(new Noodles("mama", "classic"), 9);
        catalog.add(new Noodles("korean", "i can afford"), 33);
        // duplicate won't update
        catalog.add(new Noodles("mama", "duplicate"), 9);
        showCatalog();
    }

    private void showCatalog() {
        System.out.println("Welcome to " + name);
        catalog.showCatalog();
    }

    public Basket newCustomerArrives() {
        Basket bk = new Basket();
        return bk;
    }

    public LineItem generateLineItem(String pName, int q) { // add to UML
        Product product = catalog.getProduct(pName);
        int price = catalog.getPrice(pName);
        LineItem lineItem = new LineItem(product, q, price);
        return lineItem;
    }

    public LineItem generateBuyNowItem(String pName) {
        // catalog.get
        LineItem lineItem = new LineItem(
            catalog.getProduct(pName),
            1, // quantity just by only one item
            catalog.getPrice(pName)
        );
        // !
        // ordersToday.add()
        // getPayment(null);
        return lineItem;
    }

    public void getPayment(Basket bk) {
        System.out.println("I'm cashier");
        bk.printInvoice();
        ordersToday.add(bk);
        // addBasketToOrdersToday(bk);

        // System.out.println("Invoice header");
        // b.
    }

    public void dailySalesReport() {
        System.out.println(Colors.ANSI_BLUE + "ORDERS TODAY" + Colors.ANSI_WHITE);
        // bk
        for (Basket bk : ordersToday) {
            // bk.showItemsInBasket();
            bk.printInvoice();
            // System.out.println();
            // System.out.println(bk);
        }
    }

    // public static void addBasketToOrdersToday(Basket bk) {
    //     ordersToday.add(bk);
    // }
    public void buyNow(LineItem item, Basket bk) {
        // System.out.println("Item to buy now : " + item);
        bk.putInBasket(item);
        // bk.printInvoice();
        getPayment(bk);
        // ordersToday.add(bk);
        // Shop.getPayment(this);
        // Shop.addBasketToOrdersToday(null);
    }
}
