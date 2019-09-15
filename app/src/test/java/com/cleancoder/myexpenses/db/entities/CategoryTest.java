package com.cleancoder.myexpenses.db.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    @Test
    public void getId() {
        Type expenseType = new Type("EXPENSE", "Expense");
        Category category = new Category("categoryCode", "categoryDescription", expenseType);

        assertEquals((Long) 0L, category.id);
    }
}