package com.cleancoder.myexpenses.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cleancoder.myexpenses.db.entities.Account;

@Dao
public interface AccountRepositoryContract {

    @Query("SELECT * from account where id = :id")
    Account get(Long id);

    @Query("SELECT * from account where number = :number")
    Account get(String number);

    @Insert
    Long create(Account account);

    @Update
    int update(Account account);

    @Delete
    int delete(Account account);
}
