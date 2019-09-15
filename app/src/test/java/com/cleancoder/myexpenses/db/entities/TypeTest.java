package com.cleancoder.myexpenses.db.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class TypeTest {

    private Type type = new Type("code", "description");

    @Test
    public void getId() {
        assertEquals(Long.valueOf(0L), type.id);
    }

    @Test
    public void getId2() {
        type = new Type(20L, "code", "description");
        assertEquals(Long.valueOf(20L), type.id);
    }

    @Test
    public void getCode() {
        assertEquals("code", type.code);
    }

    @Test
    public void getDescription() {
        assertEquals("description", type.description);
    }
}