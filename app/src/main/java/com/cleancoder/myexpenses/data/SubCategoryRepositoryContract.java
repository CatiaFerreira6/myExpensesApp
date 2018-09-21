package com.cleancoder.myexpenses.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.cleancoder.myexpenses.models.SubCategory;

import java.util.List;

@Dao
public interface SubCategoryRepositoryContract {

    @Query("SELECT * from sub_category where id = :id")
    SubCategory get(Long id);

    @Query("SELECT * from sub_category where code = :code")
    SubCategory get(String code);

    @Query("SELECT * from sub_category where category_id = :id")
    List<SubCategory> getByCategory(Long id);

    @Query("SELECT * from sub_category " +
            "inner join category on category.id = category_id " +
            "where category.code = :code")
    List<SubCategory> getByCategory(String code);

    //SubCategory create(SubCategory newSubCategory);
    //SubCategory update(SubCategory updatedSubCategory);
    //boolean delete(Long id);
}
