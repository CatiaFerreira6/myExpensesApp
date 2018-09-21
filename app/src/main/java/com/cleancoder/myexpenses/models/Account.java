package com.cleancoder.myexpenses.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "account", indices = {@Index(value = {"number"}, unique = true)})
public class Account {

    @PrimaryKey(autoGenerate = true)
    private Long id = 0L;

    @NonNull
    @ColumnInfo(name = "number")
    private String number;

    @ColumnInfo(name = "description")
    public String description;

    @NonNull
    @ColumnInfo(name = "balance")
    private Double balance;

    public Account(@NonNull String number, @NonNull Double balance, String description) {
        this.number = number;
        this.description = description;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Double getBalance() {
        return balance;
    }
}
