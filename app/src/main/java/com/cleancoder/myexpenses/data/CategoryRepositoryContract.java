package com.cleancoder.myexpenses.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cleancoder.myexpenses.models.Category;

@Dao
public interface CategoryRepositoryContract {

    @Query("SELECT * from category where id = :id")
    Category get(Long id);

    @Query("SELECT * from category where code = :code")
    Category get(String code);

    @Insert
    Category create(Category newCategory);

    @Update
    Category update(Category updatedCategory);

    @Delete
    void delete(Long id);

}
