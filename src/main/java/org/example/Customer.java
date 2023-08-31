package org.example;

import java.math.BigDecimal;
import java.util.Random;

public class Customer {

    private static final String ACCOUNT_NUMBER_PREFIX = "KYK";
    private static final int ACCOUNT_NUMBER_LENGTH = 10;
    private String accountNumber;
    private BigDecimal balance;

    public Customer() {
        balance = BigDecimal.valueOf(0);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void withdrawMoney(BigDecimal amount) {
        if (amount.compareTo(balance) <= 0) {
            setBalance(balance.subtract(amount));
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    public void depositMoney(BigDecimal amount) {
        setBalance(balance.add(amount));
    }

    public String generateAccountNumber() {
        StringBuilder accountNumber = new StringBuilder(ACCOUNT_NUMBER_PREFIX);
        Random random = new Random();

        for (int i = 0; i < ACCOUNT_NUMBER_LENGTH - ACCOUNT_NUMBER_PREFIX.length(); i++) {
            int digit = random.nextInt(10);
            accountNumber.append(digit);
        }

        return accountNumber.toString();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
