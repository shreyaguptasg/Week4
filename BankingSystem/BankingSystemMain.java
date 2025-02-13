package Day2.BankingSystem;
import java.util.*;

class BankingSystem {
    private final HashMap<String, Double> accounts; // Stores account number -> balance
    private final TreeMap<String, Double> sortedAccounts; // Sorts accounts by balance
    private final Queue<String> withdrawalQueue; // Queue for processing withdrawals

    public BankingSystem() {
        accounts = new HashMap<>();
        sortedAccounts = new TreeMap<>(Comparator.comparing(accounts::get)); // Sort by balance
        withdrawalQueue = new LinkedList<>();
    }

    // Add a new account
    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        updateSortedAccounts();
    }

    // Deposit money into an account
    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, accounts.get(accountNumber) + amount);
            updateSortedAccounts();
        } else {
            System.out.println("Account not found!");
        }
    }

    // Request a withdrawal (adds to queue)
    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
            System.out.println("Withdrawal request added for account: " + accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Process withdrawals
    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            if (accounts.get(accountNumber) >= amount) {
                accounts.put(accountNumber, accounts.get(accountNumber) - amount);
                System.out.println("Withdrawal of " + amount + " processed for " + accountNumber);
            } else {
                System.out.println("Insufficient funds for account: " + accountNumber);
            }
        }
        updateSortedAccounts();
    }

    // Update sortedAccounts map dynamically
    private void updateSortedAccounts() {
        sortedAccounts.clear();
        accounts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()) // Sort by balance
                .forEach(entry -> sortedAccounts.put(entry.getKey(), entry.getValue()));
    }

    // Display all accounts
    public void displayAccounts() {
        System.out.println("\nCustomer Accounts:");
        accounts.forEach((acc, balance) ->
                System.out.println("Account: " + acc + " | Balance: " + balance));
    }

    // Display accounts sorted by balance
    public void displaySortedAccounts() {
        System.out.println("\nAccounts Sorted by Balance:");
        sortedAccounts.forEach((acc, balance) ->
                System.out.println("Account: " + acc + " | Balance: " + balance));
    }
}

public class BankingSystemMain {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Adding customer accounts
        bank.addAccount("A1001", 5000.0);
        bank.addAccount("A1002", 2500.0);
        bank.addAccount("A1003", 8000.0);
        bank.addAccount("A1004", 1200.0);

        // Display all accounts
        bank.displayAccounts();

        // Request withdrawals
        bank.requestWithdrawal("A1001");
        bank.requestWithdrawal("A1003");
        bank.requestWithdrawal("A1004");

        // Process withdrawals
        bank.processWithdrawals(1000);

        // Display sorted accounts
        bank.displaySortedAccounts();
    }
}
