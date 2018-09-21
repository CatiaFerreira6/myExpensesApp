package com.cleancoder.myexpenses.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.cleancoder.myexpenses.models.Type;

@Dao
public interface TypeRepositoryContract {

    @Query("SELECT * from type where id = :id")
    Type get(Long id);

    @Query("SELECT * from type where code = :code")
    Type get(String code);
}
