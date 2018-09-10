package com.cleancoder.myexpenses.data;

import com.cleancoder.myexpenses.models.Category;
import com.cleancoder.myexpenses.models.Type;

import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryRepositoryImplementationTest {

    private CategoryRepositoryImplementation categoryRepo = new CategoryRepositoryImplementation();

    private Type expenseType = new Type("EXPENSE", "Expense");

    @Test
    public void get() {
        Category category = categoryRepo.get(0L);

        assertEquals(category.getId(), Long.valueOf(0L));

        category = categoryRepo.get(50L);

        assertNull(category);
    }

    @Test
    public void get1() {
        Category category = categoryRepo.get("FOOD");

        assertEquals(category.getCode(), "FOOD");

        category = categoryRepo.get("NON_EXISTANT");

        assertNull(category);
    }

    @Test
    public void create() {
        Category newCat = new Category("NEW_CATEGORY", "New Category", expenseType);

        Category createdCategory = categoryRepo.create(newCat);

        assertEquals(createdCategory, newCat);
    }

    @Test
    public void update() {
        Category updated = new Category("HOME", "Home 1", expenseType);

        Category updatedCat = categoryRepo.update(updated);

        assertEquals(updated, updatedCat);

        Category notUpdated = new Category(10L, "NOP", "Home 1", expenseType);

        updatedCat = categoryRepo.update(notUpdated);

        assertNull(updatedCat);
    }

    @Test
    public void delete() {
        categoryRepo.delete(0L);

        Category firstCategory = categoryRepo.get(0L);

        assertEquals(firstCategory.description, "Food");
    }
}