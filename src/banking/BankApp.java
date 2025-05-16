package banking;

import java.util.*;

public class BankApp {
    private static Scanner sc = new Scanner(System.in);
    private static int accountCounter = 100;

    public static void main(String[] args) {
        System.out.println("Select Bank Type: 1. Nationalized  2. Cooperative");
        int bankChoice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Bank Name: ");
        String bankName = sc.nextLine();
        System.out.print("Enter Branch Name: ");
        String branchName = sc.nextLine();

        Bank bank = null;
        if (bankChoice == 1) {
            bank = new NationalizedBank(bankName, branchName);
        } else {
            bank = new CooperativeBank(bankName, branchName);
        }

        boolean running = true;
        while (running) {
            System.out.println("\n1. Open Account\n2. Deposit\n3. Withdraw\n4. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    openAccount(bank);
                    break;
                case 2:
                    performDeposit(bank);
                    break;
                case 3:
                    performWithdraw(bank);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void openAccount(Bank bank) {
        System.out.println("Enter Account Type: 1. Savings  2. Current  3. Loan");
        int type = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Holder Name: ");
        String holder = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        String accNum = "ACC" + (++accountCounter);
        Account account = null;

        switch (type) {
            case 1:
                account = new SavingsAccount(accNum, holder, bal);
                break;
            case 2:
                account = new CurrentAccount(accNum, holder, bal);
                break;
            case 3:
                account = new LoanAccount(accNum, holder, bal);
                break;
            default:
                System.out.println("Invalid account type.");
                return;
        }

        bank.openAccount(account);
        System.out.println("Account Number: " + accNum);
    }

    private static void performDeposit(Bank bank) {
        sc.nextLine();
        System.out.print("Enter Branch Name: ");
        String branchName = sc.nextLine();
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        System.out.print("Enter Amount to Deposit: ");
        double amount = sc.nextDouble();

        List<Account> accounts = getAccountsByBranch(bank, branchName);
        for (Account acc : accounts) {
            if (acc.accountNumber.equals(accNum)) {
                acc.deposit(amount);
                return;
            }
        }
        System.out.println("Account not found in branch: " + branchName);
    }

    private static void performWithdraw(Bank bank) {
        sc.nextLine();
        System.out.print("Enter Branch Name: ");
        String branchName = sc.nextLine();
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        System.out.print("Enter Amount to Withdraw: ");
        double amount = sc.nextDouble();

        List<Account> accounts = getAccountsByBranch(bank, branchName);
        for (Account acc : accounts) {
            if (acc.accountNumber.equals(accNum) && acc instanceof AccountOperations) {
                ((AccountOperations) acc).withdraw(amount);
                return;
            }
        }
        System.out.println("Account not found or invalid account type.");
    }

    private static List<Account> getAccountsByBranch(Bank bank, String branchName) {
        if (bank instanceof NationalizedBank) {
            return ((NationalizedBank) bank).getAccountsByBranch(branchName);
        } else if (bank instanceof CooperativeBank) {
            return ((CooperativeBank) bank).getAccountsByBranch(branchName);
        }
        return new ArrayList<>();
    }
}
