package com.cleancoder.myexpenses.models;

import java.util.Date;

public class Record {

    private Long id = 0L;
    private Date date;
    public String description;
    public Double value;
    private Double currentBalance;

    public Category category;
    public Type type;
    public SubCategory subCategory;
    private Account account;

    public Record(Category category, Type type, SubCategory subCategory, Account account,
                  Date date, String description, Double value) {
        this.category = category;
        this.type = type;
        this.subCategory = subCategory;
        this.account = account;
        this.date = date;
        this.description = description;
        this.value = value;

        if(account != null) {
            this.currentBalance = (account.getBalance() + value);
        }
    }

    public Account getAccount() {
        return account;
    }

    public Date getDate() {
        return date;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }
}
