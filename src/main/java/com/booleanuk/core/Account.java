package com.booleanuk.core;

public class Account{
    private String accName;
    private float balance;
    private BankStatement bankStatement;

    public Account(String accName){
        this.accName = accName;
        this.balance = 0.0f;
        bankStatement = new BankStatement();
    }

    public String getAccName() {
        return accName;
    }

    public float getBalance() {
        return balance;
    }

    public BankStatement getBankStatement() {
        return bankStatement;
    }

    public boolean deposit(float amount){
        if(amount > 0) {
            this.balance += amount;
            makeTransaction(amount, "Credit");
            return true;
        }
        return false;
    }

    public boolean withdraw(float amount){
        if(amount>0 && this.balance>amount){
            this.balance -= amount;
            makeTransaction(amount, "Debit");
            return true;
        }
        return false;
    }

    public boolean makeTransaction(float amount, String type){
        Transaction transaction;
        if(type == "Credit") {
            transaction = new Transaction(amount, 0f, this.balance);
            bankStatement.getTransactions().add(transaction);
        }else if(type == "Debit") {
            transaction = new Transaction(0f, amount, this.balance);
            bankStatement.getTransactions().add(transaction);
        }
        return true;
    }

    public String getBankStatementOutput(){
        return "";
    }
}
