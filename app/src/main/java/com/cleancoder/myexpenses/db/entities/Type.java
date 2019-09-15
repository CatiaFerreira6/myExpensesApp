package com.cleancoder.myexpenses.db.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "type", indices =  {@Index(value = {"code"}, unique = true)})
public class Type {

    @PrimaryKey(autoGenerate = true)
    public Long id = 0L;

    @NonNull
    @ColumnInfo(name = "code")
    public String code;

    @ColumnInfo(name = "description")
    public String description;

    public Type(@NonNull String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Ignore
    public Type(Long id, @NonNull String code, String description){
        this.id = id;
        this.code = code;
        this.description = description;
    }
}
