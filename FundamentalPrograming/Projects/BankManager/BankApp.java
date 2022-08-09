package FundamentalPrograming.Projects.BankManager;
import java.util.Scanner;
// import com..;

public class BankApp {
    public static void main(String[] args) {
        // ? run by : java fuilename.java
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter your 'Name' and 'CustomerId' to access your data");
        // String name = sc.nextLine();
        // String customerId = sc.nextLine();
        String name = "Will";
        String customerId = "00009999";
        System.out.println(name + " " + customerId);
        
        BankAccount ba = new BankAccount(name, customerId);
        System.out.println(ba);
        // System.out.println(new BankAccount(name, customerId));
    }

}
