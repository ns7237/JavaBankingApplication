package banking;

public abstract class Bank {
    protected String bankName;
    protected String branchName;
    private static int bankCounter = 0;
    private final String bankCode;
    public static final String BANK_CODE_PREFIX = "BANK-";

    public Bank(String bankName, String branchName) {
        this.bankName = bankName;
        this.branchName = branchName;
        this.bankCode = generateBankCode();
    }

    private String generateBankCode() {
        bankCounter++;
        return BANK_CODE_PREFIX + String.format("%03d", bankCounter);
    }

    public String getBankCode() {
        return bankCode;
    }

    public abstract void openAccount(Account account);
}
