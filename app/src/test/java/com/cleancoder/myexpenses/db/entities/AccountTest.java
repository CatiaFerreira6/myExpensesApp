package com.cleancoder.myexpenses.db.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    private Account acc = new Account("accountNumber", 2300d, "accountDescription");

    @Test
    public void getId() {
        assertEquals((Long) 0L, acc.id);
    }

    @Test
    public void getNumber() {
        assertEquals("accountNumber", acc.number);
    }

    @Test
    public void getBalance() {
        assertEquals(Double.valueOf(2300d), acc.balance);
    }
}