package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankingTranscationTest {
    private BankingTranscation account;

    @BeforeEach
    void setUp() {
        // Create a BankAccount with an initial balance of 1000
        account = new BankingTranscation(1000);
    }

    @Test
    void testDeposit() {
        // Initial balance is 1000
        account.deposit(500);  // Deposit 500
        assertEquals(1500, account.getBalance(), "Balance should be 1500 after deposit");

        account.deposit(200);  // Deposit 200
        assertEquals(1700, account.getBalance(), "Balance should be 1700 after deposit");
    }

    @Test
    void testWithdrawSuccess() {
        // Initial balance is 1000
        assertTrue(account.withdraw(200), "Withdrawal of 200 should succeed");
        assertEquals(800, account.getBalance(), "Balance should be 800 after withdrawal");
    }

    @Test
    void testWithdrawInsufficientFunds() {
        // Initial balance is 1000
        assertFalse(account.withdraw(1500), "Withdrawal of 1500 should fail due to insufficient funds");
        assertEquals(1000, account.getBalance(), "Balance should remain 1000 after failed withdrawal");
    }

    @Test
    void testWithdrawNegativeAmount() {
        // Initial balance is 1000
        assertFalse(account.withdraw(-100), "Withdrawal of negative amount should fail");
        assertEquals(1000, account.getBalance(), "Balance should remain 1000 after invalid withdrawal");
    }

    @Test
    void testDepositNegativeAmount() {
        // Initial balance is 1000
        account.deposit(-500);  // Invalid deposit amount
        assertEquals(1000, account.getBalance(), "Balance should remain 1000 after invalid deposit");
    }

    @Test
    void testWithdrawZeroAmount() {
        // Initial balance is 1000
        assertFalse(account.withdraw(0), "Withdrawal of zero should fail");
        assertEquals(1000, account.getBalance(), "Balance should remain 1000 after invalid withdrawal");
    }

}