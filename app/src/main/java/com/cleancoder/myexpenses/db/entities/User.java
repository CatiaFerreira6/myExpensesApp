package com.cleancoder.myexpenses.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "user", indices = {@Index(value = {"username"}, unique = true)})
public class User {

    @PrimaryKey(autoGenerate = true)
    public Long id = 0L;

    @NonNull
    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "name")
    public String name;

    @NonNull
    @ColumnInfo(name = "account_id")
    public Long accountId;

    @NonNull
    @ColumnInfo(name = "email")
    public String email;

    @NonNull
    @ColumnInfo(name = "password")
    public String password;

    public User(@NonNull String username, @NonNull Long accountId, @NonNull String email, @NonNull String password, String name) {
        this.username = username;
        this.accountId = accountId;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
