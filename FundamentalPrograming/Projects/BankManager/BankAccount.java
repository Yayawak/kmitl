package FundamentalPrograming.Projects.BankManager;


public class BankAccount {
    double balance; // current money
    double prevTrans;
    String customerName;
    String customerId;    

    BankAccount(String customerName, String customerId) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    // add money
    void deposit(double amount) {
        if (amount != 0 ) {
            balance += amount;
            prevTrans = amount;
        }
    }
    // subtract money
    void withDraw(double amt) {
        if (amt != 0 && balance > amt) {
            balance -= amt;
            prevTrans = -amt;
        }
        else if ( balance < amt ) {
            System.out.println("No enough money to with draw");
        }
    }
    void getPrevTrans() {
        if(prevTrans > 0 ) {
            System.out.println("Deposited : " + prevTrans);
        }
        else if (prevTrans < 0 ) {
            System.out.println("Withdrawn : " + Math.abs(prevTrans));
        }
        else {
            System.out.println("No transanction occured");
        }
    }
}

