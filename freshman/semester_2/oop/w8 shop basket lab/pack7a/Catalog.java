package pack7a;

import java.util.HashMap;
import java.util.Map;

import javax.swing.plaf.BorderUIResource.EtchedBorderUIResource;

public class Catalog {
    private Map<String, Product> productList;
    private Map<String, Integer> priceList;

    public Catalog() {
        productList = new HashMap<>();
        priceList = new HashMap<>();
    }

    public void add(Product product, int price) {
        productList.put(product.getpName(), product);
        priceList.put(product.getpName(), price);
    }

    public void showCatalog() {
        for (String productName : productList.keySet()) {
            int price = priceList.get(productName);
            System.out.format("%s @ %d\n", productName, price);
        }
    }

    public int getPrice(String productName) {
        return
            productList.get(productName) != null ?
            priceList.get(productName) :
            789;
    }

    public Product getProduct(String productName) {
        if (productList.get(productName) != null) {
            return productList.get(productName);
        }
        else {
            System.out.println("Product is null");
            return null;
        }
    }
}
