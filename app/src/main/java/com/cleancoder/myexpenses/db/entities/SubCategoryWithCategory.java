package com.cleancoder.myexpenses.db.entities;

import android.arch.persistence.room.Embedded;


public class SubCategoryWithCategory {

    @Embedded(prefix = "category_")
    public Category category;

    @Embedded(prefix = "subcat")
    public SubCategory subCategory;
}
