package com.cleancoder.myexpenses.db.entities;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class RecordTest {

    private Account acct = new Account("number", 3000d, "description");
    private Date newDate = new Date();

    private Record record = new Record(acct, new SubCategory("code", null, 1L), newDate, 230.23, null);

    @Test
    public void getAccount() {
        assertEquals(acct,record.account);
    }

    @Test
    public void getDate() {
        assertEquals(newDate, record.date);
    }

    @Test
    public void getCurrentBalance() {
        Double recordBalance = 3000d + 230.23;
        assertEquals(recordBalance, record.currentBalance);
    }
}