package com.cleancoder.myexpenses.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cleancoder.myexpenses.db.entities.Type;

import java.util.List;

@Dao
public interface TypeRepositoryContract {

    @Query("SELECT * from type")
    List<Type> types();

    @Query("SELECT * from type where id = :id")
    Type get(Long id);

    @Query("SELECT * from type where code = :code")
    Type get(String code);

    @Insert
    Type create(Type type);

    @Update
    Type update(Type type);

    @Delete
    boolean delete(Long id);
}
