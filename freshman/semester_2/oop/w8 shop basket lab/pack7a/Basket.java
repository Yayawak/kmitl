package pack7a;

import java.util.ArrayList;

// import packColors.Colors;


// import org.fusesource.jansi.AnsiColors;

// import jansi.src.main.java.org.fusesource.jansi.io.Colors;
// import jansi.src.main.java.org.fusesource.jansi.*;;;


public class Basket {
    private ArrayList<LineItem> items = new ArrayList<>();

    public void showItemsInBasket() {
        // AnsC
        System.out.println("This bucket contains");
        for(LineItem lineItem : items) {
            System.out.println(lineItem);
        }
    }

    public void putInBasket(LineItem item) {
        items.add(item);
    }

    public void printInvoice() {
        // Colors.roud
        // Colors.ANSI_BLACK_BACKGROUND;
        // String leadingStr = "---^---%".repeat(4);
        String leadingStr = String.format("%s---%s^%s---%s",
            Colors.ANSI_RED,
            Colors.ANSI_CYAN,
            Colors.ANSI_GREEN,
            Colors.ANSI_WHITE
        ).repeat(4);
        // System.out.println("invoice header\n");
        // System.out.println(leadingStr);
        System.out.println("invoice header");
        int sum = 0;
        for (LineItem line : items) {
            System.out.println("\t" +
                line.getProduct().getpName() +
                " x " +
                line.getQuantity() +
                " " + line.calculateAmount()
            );
            sum += line.calculateAmount();
        }
        System.out.println("Total is " + sum + "******");
        System.out.println(leadingStr);
        // System.out.println();
    }
}
