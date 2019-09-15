package com.cleancoder.myexpenses.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

import com.cleancoder.myexpenses.db.entities.SubCategory;
import com.cleancoder.myexpenses.db.entities.SubCategoryWithCategory;

import java.util.List;

@Dao
public interface SubCategoryRepositoryContract {

    @Query("SELECT * from sub_category where id = :id")
    SubCategory get(Long id);

    @Query("SELECT * from sub_category where code = :code")
    SubCategory get(String code);

    @Query("SELECT * from sub_category where category_id = :id")
    List<SubCategory> getByCategory(Long id);

    @Transaction
    @Query("SELECT subcat.id as subcatid, subcat.code as subcatcode, subcat.description as subcatdescription, " +
            "subcat.category_id as subcatcategory_id, category.id as category_id, " +
            "category.code as category_code, category.description as category_description, " +
            "category.type_id as category_type_id " +
            "from sub_category as subcat " +
            "inner join category on category.id = category_id " +
            "where category.code = :code")
    List<SubCategoryWithCategory> getByCategory(String code);

    @Insert
    Long create(SubCategory newSubCategory);

    @Update
    int update(SubCategory updatedSubCategory);

    @Delete
    int delete(SubCategory subCategory);
}
