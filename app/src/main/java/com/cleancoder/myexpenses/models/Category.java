package com.cleancoder.myexpenses.models;

public class Category {

    private Long id = 0L;
    private String code;
    public String description;
    public Type type;

    public Category(Long id, String code, String description, Type type) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.type = type;
    }

    public Category(String code, String description, Type type) {
        this.code = code;
        this.description = description;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }
}
