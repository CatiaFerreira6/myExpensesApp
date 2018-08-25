package com.cleancoder.myexpenses.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubCategoryTest {

    private SubCategory subCategory = new SubCategory("code", "description");

    @Test
    public void getId() {
        assertEquals(Long.valueOf(0L), subCategory.getId());
    }

    @Test
    public void getDescription() {
        assertEquals("description", subCategory.getDescription());
    }
}