package com.cleancoder.myexpenses.models;

public class Category {

    private Long id = 0L;
    public String code;
    public String description;

    public Category(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public Long getId() {
        return id;
    }
}
