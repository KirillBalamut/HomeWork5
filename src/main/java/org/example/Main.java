package org.example;

import java.time.LocalDate;

class Account {
    private double balance;

    public void put(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void take(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getAmount() {
        return balance;
    }
}

class CreditAccount extends Account {
    @Override
    public void take(double amount) {
        if (amount > 0 && amount <= getAmount()) {
            double fee = amount * 0.01;
            super.take(amount + fee);
        }
    }
}

class DepositAccount extends Account {
    private LocalDate lastWithdrawalDate;

    public void setLastWithdrawalDate(LocalDate date) {
        this.lastWithdrawalDate = date;
    }

    @Override
    public void take(double amount) {
        if (amount > 0 && amount <= getAmount() && lastWithdrawalDate == null) {
            super.take(amount);
            lastWithdrawalDate = LocalDate.now();
        }
    }
}

