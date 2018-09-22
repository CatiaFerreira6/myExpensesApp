package com.cleancoder.myexpenses.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cleancoder.myexpenses.db.entities.Category;

@Dao
public interface CategoryRepositoryContract {

    @Query("SELECT * from category " +
            "inner join type on type.id = type_id " +
            "where id = :id")
    Category get(Long id);

    @Query("SELECT * from category " +
            "inner join type on type.id = type_id " +
            "where code = :code")
    Category get(String code);

    @Query("SELECT * from category " +
            "inner join type on type.id = type_id " +
            "where type.code = :code")
    Category getByType(String code);

    @Insert
    Category create(Category newCategory);

    @Update
    Category update(Category updatedCategory);

    @Delete
    void delete(Long id);

}
