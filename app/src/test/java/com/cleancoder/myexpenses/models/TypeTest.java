package com.cleancoder.myexpenses.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class TypeTest {

    private Type type = new Type("code", "description");

    @Test
    public void getId() {
        assertEquals(Long.valueOf(0L), type.getId());
    }
}