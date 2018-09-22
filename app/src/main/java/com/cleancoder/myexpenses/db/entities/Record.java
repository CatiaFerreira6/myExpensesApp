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
        indices = {@Index("account_id"), @Index(value = {"date", "value", "account_id"}, unique = true)},
        foreignKeys = {
            @ForeignKey(entity = Account.class, parentColumns = "id", childColumns = "account_id"),
            @ForeignKey(entity = SubCategory.class, parentColumns = "id", childColumns = "sub_category_id")
        })
public class Record {

    @PrimaryKey(autoGenerate = true)
    private Long id = 0L;

    @NonNull
    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "description")
    public String description;

    @NonNull
    @ColumnInfo(name = "value")
    public Double value;

    @NonNull
    @ColumnInfo(name = "current_balance")
    private Double currentBalance;

    @NonNull
    @ColumnInfo(name = "subcategory_id")
    private Long subCategoryId;

    @NonNull
    @ColumnInfo(name = "account_id")
    private Long accountId;

    @Ignore
    private SubCategory subCategory;

    @Ignore
    private Account account;

    public Record(@NonNull Account account, @NonNull SubCategory subCategory,
                  @NonNull Date date, @NonNull Double value, String description) {
        this.date = date;
        this.description = description;
        this.value = value;

        this.currentBalance = (account.getBalance() + value);
        this.accountId = account.getId();
        this.account = account;

        this.subCategory = subCategory;
        this.subCategoryId = subCategory.getId();
    }

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public SubCategory getSubCategoryId() { return subCategory; }

    public Date getDate() {
        return date;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }
}
