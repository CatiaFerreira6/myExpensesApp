package com.cleancoder.myexpenses.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cleancoder.myexpenses.db.entities.User;

@Dao
public interface UserRepositoryContract {

    @Query("SELECT * from user where id = :id")
    User get(Long id);

    @Query("SELECT * from user where username = :username")
    User get(String username);

    @Query("SELECT user.* from user " +
            "inner join account on account.id = account_id " +
            "where username = :username")
    User getWithAccount(String username);

    @Query("SELECT * from user " +
            "where email = :email")
    User getByEmail(String email);

    @Insert
    Long create(User user);

    @Update
    int update(User user);

    @Delete
    int delete(User user);
}
