package com.cleancoder.myexpenses.data;

import com.cleancoder.myexpenses.models.Category;
import com.cleancoder.myexpenses.models.SubCategory;
import com.cleancoder.myexpenses.models.Type;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryRepositoryImplementation implements SubCategoryRepositoryContract {

    private List<SubCategory> subCategories = new ArrayList<>();

    public SubCategoryRepositoryImplementation(){
        Type expenseType = new Type("EXPENSE", "Expense");
        Type incomeType = new Type("INCOME", "Income");
        Category category1 = new Category("HOME", "Home", expenseType);
        Category category2 = new Category("SALARY", "Salary", incomeType);

        subCategories.add(new SubCategory("ELECTRICAL","Electrical Bill", category1));
        subCategories.add(new SubCategory("JOB","Salary from Job", category2));
    }

    public SubCategory get(Long id) {
        for(SubCategory category: subCategories){
            if(category.getId().equals(id)){
                return category;
            }
        }
        return null;
    }

    public SubCategory get(String code) {
        for(SubCategory category: subCategories){
            if(category.getCode().toLowerCase().equals(code.toLowerCase())){
                return category;
            }
        }
        return null;
    }

    public List<SubCategory> getByCategory(Long id) {
        List<SubCategory> subs = new ArrayList<>();
        for(SubCategory sub: subCategories){
            if(sub.getCategoryId().equals(id)){
                subs.add(sub);
            }
        }
        return subs;
    }

    public List<SubCategory> getByCategory(String code) {
        List<SubCategory> subs = new ArrayList<>();
        for(SubCategory sub: subCategories){
            if(sub.getCategoryCode().toLowerCase().equals(code.toLowerCase())){
                subs.add(sub);
            }
        }
        return subs;
    }
}
