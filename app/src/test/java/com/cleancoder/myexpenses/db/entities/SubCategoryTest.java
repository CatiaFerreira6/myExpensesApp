package com.cleancoder.myexpenses.db.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubCategoryTest {

    private Type expenseType = new Type("EXPENSE", "Expense");
    private Category category = new Category("HOME", "Home", expenseType);

    private SubCategory subCategory = new SubCategory("code", "description", category);

    @Test
    public void getId() {
        assertEquals(Long.valueOf(0L), subCategory.id);
    }

    @Test
    public void getDescription() {
        assertEquals("description", subCategory.description);
    }

    @Test
    public void getCode() {
        assertEquals("code", subCategory.code);
    }

    @Test
    public void getCategoryId() {
        assertEquals(Long.valueOf(0L), subCategory.categoryId);
    }

    @Test
    public void getCategoryCode() {
        assertEquals("HOME", subCategory.category.code);
    }
}