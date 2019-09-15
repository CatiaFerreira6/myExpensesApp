package com.cleancoder.myexpenses.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "account", indices = {@Index(value = {"number"}, unique = true)})
public class Account {

    @PrimaryKey(autoGenerate = true)
    public Long id = 0L;

    @NonNull
    @ColumnInfo(name = "number")
    public String number;

    @ColumnInfo(name = "description")
    public String description;

    @NonNull
    @ColumnInfo(name = "balance")
    public Double balance;

    public Account(@NonNull String number, @NonNull Double balance, String description) {
        this.number = number;
        this.description = description;
        this.balance = balance;
    }
}
