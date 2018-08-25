package com.cleancoder.myexpenses.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    private Account acc = new Account("accountNumber", "accountDescription", 2300d);

    @Test
    public void getId() {
        assertEquals((Long) 0L, acc.getId());
    }

    @Test
    public void getNumber() {
        assertEquals("accountNumber", acc.getNumber());
    }

    @Test
    public void getBalance() {
        assertEquals(Double.valueOf(2300d), acc.getBalance());
    }
}