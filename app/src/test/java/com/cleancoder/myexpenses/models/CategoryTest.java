package com.cleancoder.myexpenses.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    @Test
    public void getId() {
        Category category = new Category("categoryCode", "categoryDescription");

        assertEquals((Long) 0L, category.getId());
    }
}