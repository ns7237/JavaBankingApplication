package banking;

public abstract class Account {
    protected String accountNumber;
    protected String holderName;
    protected double balance;

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public abstract void showAccountType();

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited successfully. New balance: ₹" + balance);
    }

    public double getBalance() {
        return balance;
    }
}
