package com.booleanuk.core;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankStatement {
    private List<Transaction> transactions;

    BankStatement(){
        this.transactions = new ArrayList<Transaction>();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String generate() {
        String result = "date || credit || debit || balance\n";

        List<Transaction> reversedList = new ArrayList<>(transactions);
        Collections.reverse(reversedList);

        for (Transaction tran : reversedList) {
            String date = tran.getCurrDate().getDayOfMonth() + "/" +
                    tran.getCurrDate().getMonthValue() + "/" +
                    tran.getCurrDate().getYear();

            String credit = "";
            if (tran.getCredit() != 0) {
                credit = String.format("%.2f", tran.getCredit());
            }

            String debit = "";
            if (tran.getDebit() != 0) {
                debit = String.format("%.2f", tran.getDebit());
            }

            String balance = String.format("%.2f", tran.getBalance());;

            result = result + date + " || " + credit + " || " + debit + " || " + balance + "\n";
        }

        return result;
    }
}
