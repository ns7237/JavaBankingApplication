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
}
