package com.cleancoder.myexpenses.models;

public class Account {

    private Long id = 0L;
    private String number;
    public String description;

    public Account(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }
}
