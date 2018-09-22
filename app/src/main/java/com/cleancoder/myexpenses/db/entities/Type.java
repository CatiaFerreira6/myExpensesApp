package com.cleancoder.myexpenses.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "type", indices =  {@Index(value = {"code"}, unique = true)})
public class Type {

    @PrimaryKey(autoGenerate = true)
    private Long id = 0L;

    @NonNull
    @ColumnInfo(name = "code")
    private String code;

    @ColumnInfo(name = "description")
    private String description;

    public Type(@NonNull String code, String description) {
        this.code = code;
        this.description = description;
    }

    public Type(Long id, @NonNull String code, String description){
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
