package com.saravana.oops;

public class BankingApplication {

    public static void main(String[] args) {
        Account myAccount = new Account(); // Create an instance of Account
        myAccount.accountNumber = "12345";
        myAccount.balance = 1000.0;

        Account toAccount = new Account(); // Create an instance of Account
        toAccount.accountNumber = "67890";
        toAccount.balance = 500.0;

        System.out.println("Before transaction:");
        System.out.println("Account 1 balance: " + myAccount.balance);
        System.out.println("Account 2 balance: " + myAccount.balance);

        boolean status = myAccount.transact(toAccount, 200.0);

        System.out.println("After transaction:");
        System.out.println("Transaction status:" + status);
        System.out.println("Account 1 balance: " + myAccount.balance);
        System.out.println("Account 2 balance: " + toAccount.balance);
    }

}
