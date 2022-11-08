package PF.PostMidterm.LabW13;

public class Main
{

    public static void main(String[] args) {
        Account_65988 acc1 = new Account_65988(9, "Jeff", 2000);
        Account_65988 acc2 = new Account_65988(9, "Shannon", 1000);
        acc1.toString();
    }
}

class Account_65988 {
    private int id;
    private String name;
    private int balance = 0;
    Account_65988(int id, String name, int balance)
    {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public int getID() { return id; }
    public String getName() { return name; }
    public int getBalance() { return balance; }
    public int credit(int amount)
    {
        balance += amount;
        return balance;
    }
    public int debit(int amount)
    {
        if (balance >= amount)
        {
            balance -= amount;
        }
        return balance;
    }
    public int transferTo(Account_65988 acct, int amount)
    {
        if (balance >= amount)
        // if (this.balance >= amount)
        {
            acct.credit(amount);
        }
        return acct.getBalance();
    }
    // public static String toString()
    public String toString()
    {
        return String.format("Account %s(%d) balance is %d",
            name, id, balance
            // this.name, this.id, this.balance
        );
    }
}
