package com.cleancoder.myexpenses.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class TypeTest {

    private Type type = new Type("code", "description");

    @Test
    public void getId() {
        assertEquals(Long.valueOf(0L), type.getId());
    }

    @Test
    public void getId2() {
        type = new Type(20L, "code", "description");
        assertEquals(Long.valueOf(20L), type.getId());
    }

    @Test
    public void getCode() {
        assertEquals("code", type.getCode());
    }

    @Test
    public void getDescription() {
        assertEquals("description", type.getDescription());
    }
}