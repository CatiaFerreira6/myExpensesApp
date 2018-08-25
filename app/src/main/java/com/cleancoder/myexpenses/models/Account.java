package com.cleancoder.myexpenses.models;

public class Account {

    private Long id = 0L;
    private String number;
    public String description;
    private Double balance;

    public Account(String number, String description, Double balance) {
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
