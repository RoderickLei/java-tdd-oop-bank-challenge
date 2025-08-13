package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class AccountTest {
    @Test
    public void ShouldDepositAmount(){
        Account account = new Account("Test Account");

        Assertions.assertEquals(0f, account.getBalance());
        Assertions.assertTrue(account.deposit(1000f));
        Assertions.assertEquals(1000f, account.getBalance());
        Assertions.assertTrue(account.deposit(300f));
        Assertions.assertEquals(1300f, account.getBalance());

        Assertions.assertFalse(account.deposit(-100f));
        Assertions.assertFalse(account.deposit(0f));
        //Hoeveel cijfers achter de komma
    }

    @Test
    public void ShouldWithdrawAmount(){
        Account account = new Account("Test Account");

        Assertions.assertFalse(account.withdraw(500f));

        account.deposit(1000f);

        Assertions.assertTrue(account.withdraw(500f));
        Assertions.assertEquals(500f, account.getBalance());
        Assertions.assertFalse(account.withdraw(1000f));
        Assertions.assertFalse(account.withdraw(0f));
        Assertions.assertFalse(account.withdraw(-100));
    }

    @Test
    public void ShouldRegisterTransaction(){
        Account account = new Account("Test Account");

        account.deposit(1000f);
        account.withdraw(500f);

        List<Transaction> transactions = account.getBankStatement().getTransactions();

        Assertions.assertEquals(2, transactions.size());

        Transaction tran1 = transactions.get(0);
        Assertions.assertEquals(1000f, tran1.getCredit());
        Assertions.assertEquals(0f, tran1.getDebit());
        Assertions.assertEquals(1000f, tran1.getBalance());
        Assertions.assertEquals(LocalDate.now(), tran1.getCurrDate());

        Transaction tran2 = transactions.get(1);
        Assertions.assertEquals(0f, tran2.getCredit());
        Assertions.assertEquals(500f, tran2.getDebit());
        Assertions.assertEquals(500f, tran2.getBalance());
        Assertions.assertEquals(LocalDate.now(), tran2.getCurrDate());
    }
}
