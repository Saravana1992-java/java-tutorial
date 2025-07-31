package com.saravana.oops;

public class Account { // class representing a bank account

    // Attributes of the Account class
    String accountNumber;
    double balance;

    // Method to perform a transaction between two accounts
    boolean transact(Account toAccount, double amount) {
        if (this.balance >= amount) {
            this.balance -= amount; // Current Account Balance updated
            toAccount.balance += amount; // toAccount Balance updated
            return true; // Transaction successful
        }
        throw new IllegalArgumentException("Insufficient funds for transaction");
    }
}
