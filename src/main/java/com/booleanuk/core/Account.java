package com.booleanuk.core;

public class Account{
    private String accName;
    private float balance;
    private BankStatement bankStatement;

    public Account(String accName){
        this.accName = accName;
        this.balance = 0.0f;
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
        return false;
    }

    public boolean withdraw(float amount){
        return false;
    }

    public boolean makeTransaction(float amount, String type){
        return false;
    }

    public void updateBalance(float amount){

    }

    public String printBST(){
        return "";
    }
}
