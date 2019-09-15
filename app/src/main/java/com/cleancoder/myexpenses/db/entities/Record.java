package com.cleancoder.myexpenses.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

@Entity(tableName = "record",
        indices = {@Index("account_id"), @Index("subcategory_id"), @Index(value = {"date", "value", "account_id"}, unique = true)},
        foreignKeys = {
            @ForeignKey(entity = Account.class, parentColumns = "id", childColumns = "account_id"),
            @ForeignKey(entity = SubCategory.class, parentColumns = "id", childColumns = "subcategory_id")
        })
public class Record {

    @PrimaryKey(autoGenerate = true)
    public Long id = 0L;

    @NonNull
    @ColumnInfo(name = "date")
    public Date date;

    @ColumnInfo(name = "description")
    public String description;

    @NonNull
    @ColumnInfo(name = "value")
    public Double value;

    @NonNull
    @ColumnInfo(name = "current_balance")
    public Double currentBalance;

    @NonNull
    @ColumnInfo(name = "subcategory_id")
    public Long subCategoryId;

    @NonNull
    @ColumnInfo(name = "account_id")
    public Long accountId;

    @Ignore
    public SubCategory subCategory;

    @Ignore
    public Account account;

    public Record(@NonNull Long accountId, @NonNull Long subCategoryId,
                  @NonNull Date date, @NonNull Double value, String description) {
        this.date = date;
        this.description = description;
        this.value = value;

        this.currentBalance = 0.0;
        this.accountId = accountId;

        this.subCategoryId = subCategoryId;
    }

    public Record(@NonNull Account account, @NonNull SubCategory subCategory,
                  @NonNull Date date, @NonNull Double value, String description) {
        this.date = date;
        this.description = description;
        this.value = value;

        this.currentBalance = (account.balance + value);
        this.accountId = account.id;
        this.account = account;

        this.subCategory = subCategory;
        this.subCategoryId = subCategory.id;
    }
}
