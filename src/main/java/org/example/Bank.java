package org.example;

import java.math.BigDecimal;
import java.util.Scanner;

public class Bank {

    final static Scanner input = new Scanner(System.in);
    static String exit = "";

    final static String accountNumberForUser = "KYK4567890";

    final static Customer customer = new Customer();

    public static void main(String[] args) {

        System.out.println("Welcome to the Kaynak bank application" +
                "\nAre you already an user of our bank?(y/n)");
        final String isAlreadyUser = input.next().toLowerCase().substring(0, 1);

        if (isAlreadyUser.equals("n")) {
            System.out.println("Let`s create an account for you" +
                    "\nThis is your account number");
            customer.setAccountNumber(customer.generateAccountNumber());
            System.out.println(customer.getAccountNumber());
        } else {
            customer.setAccountNumber(accountNumberForUser);
        }
        System.out.println("Please enter your account number");
        final String accountNumber = input.next();
        if (accountNumber.equals(customer.getAccountNumber())) {
            do {
                System.out.println("""

                        Select the type of action you want to do
                        1-) Deposit money
                        2-) Withdraw money
                        3-) Show balance
                        9-) Exit"""
                );
                String userTransaction = input.next().substring(0, 1);
                switch (userTransaction) {
                    case "1" -> {
                        System.out.println("Please enter the amount you want to deposit");
                        BigDecimal depositAmount = input.nextBigDecimal();
                        customer.depositMoney(depositAmount);
                        System.out.printf("Your new balance is: %s PLN", customer.getBalance());
                    }
                    case "2" -> {
                        System.out.println("Please enter the amount you want to withdraw");
                        BigDecimal withdrawAmount = input.nextBigDecimal();
                        customer.withdrawMoney(withdrawAmount);
                        System.out.printf("Your new balance is: %s PLN", customer.getBalance());
                    }
                    case "3" -> System.out.println(customer);
                    case "9" -> {
                        System.out.println("See you soon!!!");
                        exit = "9";
                    }
                }
            } while (!exit.equals("9"));
        } else {
            System.out.printf("There is no account number in our system: %s%n", accountNumber);
        }
    }
}