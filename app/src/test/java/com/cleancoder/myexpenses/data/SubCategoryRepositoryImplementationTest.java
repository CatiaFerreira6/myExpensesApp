package com.cleancoder.myexpenses.data;

import com.cleancoder.myexpenses.models.SubCategory;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SubCategoryRepositoryImplementationTest {

    private SubCategoryRepositoryImplementation subCategoryRepo = new SubCategoryRepositoryImplementation();

    @Test
    public void get() {
        SubCategory subCategory = subCategoryRepo.get(0L);

        assertEquals(subCategory.getId(), Long.valueOf(0L));

        subCategory = subCategoryRepo.get(50L);

        assertNull(subCategory);
    }

    @Test
    public void get1() {
        SubCategory subCategory = subCategoryRepo.get("ELECTRICAL");

        assertEquals(subCategory.getCode(), "ELECTRICAL");

        subCategory = subCategoryRepo.get("electrical");

        assertEquals(subCategory.getCode(), "ELECTRICAL");

        subCategory = subCategoryRepo.get("POTATOES");

        assertNull(subCategory);
    }

    @Test
    public void getByCategory() {
        List<SubCategory> subs = subCategoryRepo.getByCategory(0L);

        assertEquals(subs.size(), 2);
    }

    @Test
    public void getByCategory1() {
        List<SubCategory> subs = subCategoryRepo.getByCategory("HOME");

        assertEquals(subs.size(), 1);
    }
}