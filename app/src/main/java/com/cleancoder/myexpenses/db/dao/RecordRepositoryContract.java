package com.cleancoder.myexpenses.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cleancoder.myexpenses.db.entities.Record;

import java.util.List;

@Dao
public interface RecordRepositoryContract {

    @Query("SELECT * from record where id = :id")
    Record get(Long id);

    @Query("SELECT * from record " +
            "inner join account on account.id = account_id " +
            "inner join sub_category on sub_category.id = subcategory_id " +
            "inner join category on category.id = sub_category.category_id " +
            "inner join type on type.id = category.type_id " +
            "where account_id = :accountId " +
            "order by date desc limit :limit")
    LiveData<List<Record>> getLatest(Long accountId, int limit);

    @Query("SELECT * from record " +
            "inner join account on account.id = account_id " +
            "inner join sub_category on sub_category.id = subcategory_id " +
            "inner join category on category.id = sub_category.category_id " +
            "inner join type on type.id = category.type_id " +
            "where account_id = :accountId " +
            "and type_id = :typeId " +
            "order by date desc limit :limit")
    List<Record> getLatestByType(Long accountId, Long typeId, int limit);

    @Query("SELECT * from record " +
            "inner join account on account.id = account_id " +
            "inner join sub_category on sub_category.id = subcategory_id " +
            "inner join category on category.id = sub_category.category_id " +
            "inner join type on type.id = category.type_id " +
            "where account_id = :accountId " +
            "and category_id = :categoryId " +
            "order by date desc limit :limit")
    List<Record> getLatestByCategory(Long accountId, Long categoryId, int limit);

    @Insert
    Record create(Record newRecord);

    @Update
    Record update(Record updatedRecord);

    @Delete
    void delete(Long id);
}
