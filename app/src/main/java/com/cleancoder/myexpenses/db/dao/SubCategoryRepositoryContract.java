package com.cleancoder.myexpenses.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cleancoder.myexpenses.db.entities.SubCategory;

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

    @Insert
    SubCategory create(SubCategory newSubCategory);

    @Update
    SubCategory update(SubCategory updatedSubCategory);

    @Delete
    boolean delete(Long id);
}
