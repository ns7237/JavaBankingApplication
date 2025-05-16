package banking;

import java.util.*;

public class NationalizedBank extends Bank {
    private Map<String, List<Account>> branchAccounts = new HashMap<>();

    public NationalizedBank(String bankName, String branchName) {
        super(bankName, branchName);
    }

    @Override
    public void openAccount(Account account) {
        branchAccounts.putIfAbsent(branchName, new ArrayList<>());
        branchAccounts.get(branchName).add(account);
        System.out.println("Account opened successfully in Nationalized Bank, Branch: " + branchName);
    }

    public List<Account> getAccountsByBranch(String branch) {
        return branchAccounts.getOrDefault(branch, new ArrayList<>());
    }

    @Override
    public void displayBankInfo() {
        System.out.println("--- Bank Details ---");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Branch: " + branchName);
        System.out.println("Bank Code: " + getBankCode());

        List<Account> accounts = getAccountsByBranch(branchName);
        if (accounts.isEmpty()) {
            System.out.println("No accounts found in this branch.");
            return;
        }

        for (Account acc : accounts) {
            System.out.println("\n--- Account Details ---");
            acc.showAccountType();
            System.out.println("Holder: " + acc.holderName);
            System.out.println("Account Number: " + acc.accountNumber);
            System.out.println("Balance: ₹" + acc.getBalance());
        }
    }
}
