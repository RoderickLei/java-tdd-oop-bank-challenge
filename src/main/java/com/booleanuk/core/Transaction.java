package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {
    private LocalDate currDate;
    private float credit;
    private float debit;
    private float balance;

    public Transaction(float credit, float debit, float balance){
        this.credit = credit;
        this.debit = debit;
        this.balance = balance;
        this.currDate = LocalDate.now();
    }

    public LocalDate getCurrDate() {
        return currDate;
    }

    public float getCredit() {
        return credit;
    }

    public float getDebit() {
        return debit;
    }

    public float getBalance() {
        return balance;
    }
}
