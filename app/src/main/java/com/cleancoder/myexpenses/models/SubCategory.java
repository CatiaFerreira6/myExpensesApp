package com.cleancoder.myexpenses.models;

public class SubCategory {

    private Long id = 0L;
    private String code;
    private String description;

    public SubCategory(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
