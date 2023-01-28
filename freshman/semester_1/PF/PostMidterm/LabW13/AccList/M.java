import java.util.ArrayList;

// public class M
class M
{

}

// public class AcctList_65988
class AcctList_65988
{
    // ArrayList<Account_65988> accList = new ArrayList<>();
    ArrayList<Account_65988> accList;
    // AcctList_65988(ArrayList<Account_65988> accList)

    AcctList_65988()
    {
        // this.accList = accList;
        accList = new ArrayList<>();
        accList.add(new Account_65988(1, "Cactus", 1000));
        accList.add(new Account_65988(2, "Celsia", 500));
        accList.add(new Account_65988(3, "Clove pink", 1500));
        accList.add(new Account_65988(4, "Crown Imperial", 900));
        accList.add(new Account_65988(5, "Daffodil", 1200));
        accList.add(new Account_65988(6, "Daisy", 1700));
        accList.add(new Account_65988(7, "Dandelion", 500));
        accList.add(new Account_65988(8, "Dittany", 600));
    }

    public ArrayList<String> balanceLessThan(int bound)
    {
        ArrayList<String> filteredNames = new ArrayList<>();
        for (var acc : accList)
        {
            if (acc.getBalance() < bound)
            {
                filteredNames.add(acc.getName());
            }
        }
        return filteredNames;
    }

    public ArrayList<String> filterName(String str)
    {
        char c = str.charAt(0);
        ArrayList<String> filteredNames = new ArrayList<>();
        for (var acc : accList)
        {
            if (acc.getName().toUpperCase().charAt(0) == c)
            {
                filteredNames.add(acc.getName());
            }
        }
        return filteredNames;
    }



}
// public class ProFun12_AcctDriver {
class ProFun12_AcctDriver {
    public static void main(String[] args) {
        // testAccount();
        testAcctList();
    }

    static void testAcctList() {
        AcctList_65988 clients = new AcctList_65988();
        String startWith = "c";
        System.out.println("List of account name start with " + startWith.toUpperCase());
        System.out.println(clients.filterName(startWith.toUpperCase()));
        int bound = 1400;
        System.out.println("List of account balance less than " + bound);
        System.out.println(clients.balanceLessThan(bound));
    }

    static void testAccount() {
        Account_65988 acct1 = new Account_65988(1, "melon", 1500);
        Account_65988 acct2 = new Account_65988(2, "rose apple", 2200);
        System.out.println(acct1.credit(700)); // 2200
        System.out.println(acct2.debit(300)); // 1900
        System.out.println(acct1.transferTo(acct2, 1000)); // 2200
        System.out.println(acct1.credit(-50)); // 1200
        System.out.println(acct2.debit(-50)); // 2900
        System.out.println(acct1);
        System.out.println(acct2);
    }
    // public static void main(String[] args) {
    //     AcctList_65988 clients = new AcctList_65988 ();
    //     String startWith = "c";
    //     System.out.println("List of account name start with " + startWith.toUpperCase());
    //     System.out.println(clients.filterName(startWith.toUpperCase())); //ArrayList
    //     int bound = 1400;
    //     System.out.println("List of account balance less than " + bound); //ArrayList
    //     System.out.println(clients.balanceLessThan(bound));
    // }
}
