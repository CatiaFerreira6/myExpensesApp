package com.cleancoder.myexpenses.models;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class RecordTest {

    private Account acct = new Account("number", "description", 3000d);
    private Date newDate = new Date();

    private Record record = new Record(null, null, null, acct, newDate, "description", 230.23);

    @Test
    public void getAccount() {
        assertEquals(acct,record.getAccount());
    }

    @Test
    public void getDate() {
        assertEquals(newDate, record.getDate());
    }

    @Test
    public void getCurrentBalance() {
        Double recordBalance = 3000d + 230.23;
        assertEquals(recordBalance, record.getCurrentBalance());
    }
}