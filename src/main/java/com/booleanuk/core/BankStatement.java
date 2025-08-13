package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class BankStatement {
    private List<Transaction> transactions;

    BankStatement(){
        this.transactions = new ArrayList<Transaction>();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
