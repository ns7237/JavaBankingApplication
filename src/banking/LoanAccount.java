package banking;

public class LoanAccount extends Account implements AccountOperations {
    public LoanAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void showAccountType() {
        System.out.println("Account Type: Loan Account");
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
