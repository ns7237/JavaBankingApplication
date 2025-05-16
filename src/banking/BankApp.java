package banking;

import java.util.Scanner;

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

        System.out.println("\n--- Open an Account ---");
        openAccount(bank);
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
}
