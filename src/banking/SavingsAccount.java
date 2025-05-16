package banking;

public class SavingsAccount extends Account implements AccountOperations {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void showAccountType() {
        System.out.println("Account Type: Savings Account");
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
