package com.cleancoder.myexpenses.data;

import com.cleancoder.myexpenses.models.Category;
import com.cleancoder.myexpenses.models.Type;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImplementation implements CategoryRepositoryContract {

    private List<Category> categories = new ArrayList<>();

    public CategoryRepositoryImplementation(){
        Type expenseType = new Type("EXPENSE", "Expense");
        categories.add(new Category("HOME", "Home", expenseType));
        categories.add(new Category("FOOD", "Food", expenseType));
        categories.add(new Category("HEALTH", "Health", expenseType));
        categories.add(new Category("TRANSPORTATION", "Transportation", expenseType));
        categories.add(new Category("PETS", "Pets", expenseType));
        categories.add(new Category("RANDOM", "Random", expenseType));

        Type incomeType = new Type("INCOME", "Income");
        categories.add(new Category("HOME", "Home", incomeType));
        categories.add(new Category("FOOD", "Food", incomeType));
        categories.add(new Category("HEALTH", "Health", incomeType));
        categories.add(new Category("TRANSPORTATION", "Transportation", incomeType));
        categories.add(new Category("PETS", "Pets", incomeType));
        categories.add(new Category("RANDOM", "Random", incomeType));
    }

    public Category get(Long id){
        for(Category category : categories) {
            if(category.getId().equals(id)) {
                return category;
            }
        }
        return null;
    }

    public Category get(String code){
        for(Category category : categories) {
            if(category.getCode().equals(code)) {
                return category;
            }
        }
        return null;
    }

    public Category create(Category newCategory){
        categories.add(newCategory);
        return newCategory;
    }

    public Category update(Category updatedCategory){
        Category cat = get(updatedCategory.getId());

        if(cat != null){
            int indexOf = categories.indexOf(cat);
            categories.set(indexOf, cat);
            return updatedCategory;
        }

        return null;
    }

    public void delete(Long id){
        Category cat = get(id);

        if(cat != null){
            categories.remove(categories.indexOf(cat));
        }
    }
}
