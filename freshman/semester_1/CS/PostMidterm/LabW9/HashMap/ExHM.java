import java.util.HashMap;

class ExHm
{
    public static void main(String[] args) {
        class Order
        {
            String item; int quantity;
            Order (String item, int q)
            {
                this.item = item;
                this.quantity = q;
            }
        }
        HashMap<String, Integer> menu = new HashMap<>();
        menu.put("Punch", 10);
        menu.putIfAbsent("Espresso", 15);
        menu.putIfAbsent("Lemon Tea", 19);

        System.out.println("Listing menu content");

        int i = 0;
        for (var entry : menu.entrySet())
        {
            String itemName = entry.getKey();
            int price = entry.getValue();
            System.out.printf("Item %d, ItemName %s, %d\n", ++i, itemName, price);
        }

        // todo Q1 :
        System.out.println("Listing only menu names");
        String itemNames[] = new String[menu.size()];
        int k = -1;
        for (String itemN : menu.keySet())
        {
            itemNames[++k] = itemN;
            System.out.println((itemNames[k]));
        }
        // for (String item : menu.keySet())
        //     System.out.println(item);
        // for (int quantity;)
        // for (var entry : menu.g)

        // todo Q2 :
        System.out.println("Listing only menu prices");
        // for (int quan : menu.values())
        //     System.out.println(quan);
        for (String itemN : itemNames)
        {
            System.out.println(menu.get(itemN));
        }


        Order[] table = {
            new Order("Lemon Team", 2),
            new Order("Punch Team", 3),
        };
        System.out.println("To access order detail use .");
        System.out.printf("e.g. table[0].item %s and %d\n ",
            table[0].item, table[1].quantity);
        ;
        System.out.print("Table's amount due is ");
        int amount = 0;
        // todo Q3 :
        for (int j = 0; j < table.length; j++)
            amount += table[j].quantity;
        System.out.println(amount);


    }


}
