package banking;

import java.util.*;

public class CooperativeBank extends Bank {
    private Map<String, List<Account>> branchAccounts = new HashMap<>();

    public CooperativeBank(String bankName, String branchName) {
        super(bankName, branchName);
    }

    @Override
    public void openAccount(Account account) {
        branchAccounts.putIfAbsent(branchName, new ArrayList<>());
        branchAccounts.get(branchName).add(account);
        System.out.println("Account opened successfully in Cooperative Bank, Branch: " + branchName);
    }

    public List<Account> getAccountsByBranch(String branch) {
        return branchAccounts.getOrDefault(branch, new ArrayList<>());
    }
}

