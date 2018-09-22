package com.cleancoder.myexpenses.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "category",
        indices = {@Index("type_id"), @Index(value = {"code"}, unique = true)},
        foreignKeys = @ForeignKey(entity = Type.class, parentColumns = "id", childColumns = "type_id")
        )
public class Category {

    @PrimaryKey(autoGenerate = true)
    private Long id = 0L;

    @ColumnInfo(name = "code")
    private String code;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "type_id")
    private Long typeId;

    @Ignore
    public Type type;

    public Category(Long id, String code, String description, Type type) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.type = type;

        typeId = type.getId();
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
