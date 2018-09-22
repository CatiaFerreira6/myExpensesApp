package com.cleancoder.myexpenses.db.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubCategoryTest {

    Type expenseType = new Type("EXPENSE", "Expense");
    Category category = new Category("HOME", "Home", expenseType);

    private SubCategory subCategory = new SubCategory("code", "description", category);

    @Test
    public void getId() {
        assertEquals(Long.valueOf(0L), subCategory.getId());
    }

    @Test
    public void getDescription() {
        assertEquals("description", subCategory.getDescription());
    }

    @Test
    public void getCode() {
        assertEquals("code", subCategory.getCode());
    }

    @Test
    public void getCategoryId() {
        assertEquals(Long.valueOf(0L), subCategory.getCategoryId());
    }

    @Test
    public void getCategoryCode() {
        assertEquals("HOME", subCategory.getCategoryCode());
    }
}