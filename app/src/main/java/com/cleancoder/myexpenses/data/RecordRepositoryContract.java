package com.cleancoder.myexpenses.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cleancoder.myexpenses.models.Record;

import java.util.List;

@Dao
public interface RecordRepositoryContract {

    @Query("SELECT * from record where id = :id")
    Record get(Long id);

    @Query("SELECT * from record order by date limit :limit")
    List<Record> getLatest(int limit);

    @Insert
    Record create(Record newRecord);

    @Update
    Record update(Record updatedRecord);

    @Delete
    void delete(Long id);
}
