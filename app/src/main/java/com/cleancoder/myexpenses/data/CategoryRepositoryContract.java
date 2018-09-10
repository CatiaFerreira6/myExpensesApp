package com.cleancoder.myexpenses.data;

import com.cleancoder.myexpenses.models.Category;

public interface CategoryRepositoryContract {

    Category get(Long id);

    Category get(String code);

    Category create(Category newCategory);

    Category update(Category updatedCategory);

    void delete(Long id);

}
