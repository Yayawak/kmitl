package pack7a;

public abstract class Product {
    protected String pName;
    protected String desc;

    public Product(String n, String d) {
        pName = n;
        desc = d;
    }

    public String getpName() {
        return pName;
    }

    public String getDesc() {
        return desc;
    }

    // ? not called because it's abstract class
    // @Override
    // public String toString() {
    //     System.out.println("callefd to string of product");
    //     String str =
    //         String.format("product name : %s, describtion %s\n",
    //         this.pName, this.desc
    //     );
        // return str;
    // }
}
