package com.cleancoder.myexpenses.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;
import android.support.annotation.NonNull;

@Entity(tableName = "sub_category",
        indices = {@Index("category_id"), @Index(value = {"code"}, unique = true)},
        foreignKeys = @ForeignKey(entity = Category.class, parentColumns = "id", childColumns = "category_id")
)
public class SubCategory {

    @PrimaryKey(autoGenerate = true)
    public Long id = 0L;

    @NonNull
    @ColumnInfo(name = "code")
    public String code;

    @ColumnInfo(name = "description")
    public String description;

    @NonNull
    @ColumnInfo(name = "category_id")
    public Long categoryId;

    @Ignore
    public Category category;

    public SubCategory(@NonNull String code, String description, @NonNull Long categoryId) {
        this.code = code;
        this.description = description;
        this.categoryId = categoryId;
    }

    public SubCategory(@NonNull String code, String description, @NonNull Category category) {
        this.code = code;
        this.description = description;
        this.category = category;

        categoryId = category.id;
    }
}
