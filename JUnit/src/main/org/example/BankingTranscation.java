package org.example;
public class BankingTranscation  {
    private double balance;

    // Constructor to initialize the balance
    public BankingTranscation (double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            return true;  // Withdrawal successful
        }
        return false;  // Insufficient funds or invalid amount
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }
}

