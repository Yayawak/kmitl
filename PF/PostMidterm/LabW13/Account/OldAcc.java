package PF.PostMidterm.LabW13;

public class OldAcc {
    public static void main(String[] args) {
        Account_65988 acc1 = new Account_65988(9, "Jeff", 2000);
        Account_65988 acc2 = new Account_65988(9, "Shannon", 1000);
        System.out.println(acc1.toString());
        System.out.println(acc1.getID());
        System.out.println(acc1.getName());
        System.out.println(acc1.getBalance());

        System.out.println(acc1.credit(5000));
        System.out.println(acc1.toString());
        System.out.println(acc1.debit(3000));
        System.out.println("Transfer to acc2");
        System.out.println(acc1.transferTo(acc2, 888));
    }
    private int id;
    private String name;
    private int balance = 0;
    Account_65988(int id, String name, int balance)
    {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public int getID() { return this.id; }
    public String getName() { return this.name; }
    public int getBalance() { return this.balance; }
    public int credit(int amount)
    {
        this.balance += amount;
        return this.balance;
    }
    public int debit(int amount)
    {
        if (this.balance >= amount)
        {
            this.balance -= amount;
        }
        return this.balance;
    }
    public int transferTo(Account_65988 acct, int amount)
    {
        if (this.balance >= amount)
        {
            acct.credit(amount)
        }
        return acct.getBalance();
    }
    public String toString()
    {
        String.format("Account %s(%d) balance is %d", this.name,
            this.id, this.balance)
    }
}
