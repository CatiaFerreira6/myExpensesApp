package com.cleancoder.myexpenses.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cleancoder.myexpenses.db.entities.Record;
import com.cleancoder.myexpenses.db.entities.RecordWithEntities;

import java.util.List;

@Dao
public interface RecordRepositoryContract {

    @Query("SELECT * from record where id = :id")
    Record get(Long id);

    @Query("SELECT record.*, " +
            "acc.id as accid, acc.number as accnumber, acc.description as accdescription, acc.balance as accbalance, " +
            "subcat.id as subcatid, subcat.description as subcatdescription, subcat.code as subcatcode, subcat.category_id as subcatcategory_id " +
            "from record " +
            "inner join account as acc on acc.id = account_id " +
            "inner join sub_category as subcat on subcat.id = subcategory_id " +
            "inner join category on category.id = subcat.category_id " +
            "inner join type on type.id = category.type_id " +
            "where account_id = :accountId " +
            "order by date desc limit :limit")
    LiveData<List<RecordWithEntities>> getLatest(Long accountId, int limit);

    @Query("SELECT record.*, " +
            "acc.id as accid, acc.number as accnumber, acc.description as accdescription, acc.balance as accbalance, " +
            "subcat.id as subcatid, subcat.description as subcatdescription, subcat.code as subcatcode, subcat.category_id as subcatcategory_id " +
            "from record " +
            "inner join account as acc on acc.id = account_id " +
            "inner join sub_category as subcat on subcat.id = subcategory_id " +
            "inner join category on category.id = subcat.category_id " +
            "inner join type on type.id = category.type_id " +
            "where account_id = :accountId " +
            "and type_id = :typeId " +
            "order by date desc limit :limit")
    List<RecordWithEntities> getLatestByType(Long accountId, Long typeId, int limit);

    @Query("SELECT record.*, " +
            "acc.id as accid, acc.number as accnumber, acc.description as accdescription, acc.balance as accbalance, " +
            "subcat.id as subcatid, subcat.description as subcatdescription, subcat.code as subcatcode, subcat.category_id as subcatcategory_id " +
            "from record " +
            "inner join account as acc on acc.id = account_id " +
            "inner join sub_category as subcat on subcat.id = subcategory_id " +
            "inner join category on category.id = subcat.category_id " +
            "inner join type on type.id = category.type_id " +
            "where account_id = :accountId " +
            "and category_id = :categoryId " +
            "order by date desc limit :limit")
    List<RecordWithEntities> getLatestByCategory(Long accountId, Long categoryId, int limit);

    @Insert
    Long create(Record newRecord);

    @Update
    int update(Record updatedRecord);

    @Delete
    int delete(Record record);
}
