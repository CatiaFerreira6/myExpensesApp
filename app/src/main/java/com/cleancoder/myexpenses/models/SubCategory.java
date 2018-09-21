package com.cleancoder.myexpenses.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "sub_category",
        indices = {@Index("category_id"), @Index(value = {"code"}, unique = true)},
        foreignKeys = @ForeignKey(entity = Category.class, parentColumns = "id", childColumns = "category_id")
)
public class SubCategory {

    @PrimaryKey(autoGenerate = true)
    private Long id = 0L;

    @NonNull
    @ColumnInfo(name = "code")
    private String code;

    @ColumnInfo(name = "description")
    private String description;

    @NonNull
    @ColumnInfo(name = "category_id")
    private Long categoryId;

    @Ignore
    private Category category;

    public SubCategory(@NonNull String code, String description, @NonNull Category category) {
        this.code = code;
        this.description = description;
        this.category = category;

        categoryId = category.getId();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    public Long getCategoryId() {
        return category.getId();
    }

    public String getCategoryCode(){
        return category.getCode();
    }
}
