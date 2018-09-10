package com.cleancoder.myexpenses.data;

import com.cleancoder.myexpenses.models.Record;

import java.util.List;

public interface RecordRepositoryContract {

    Record get(Long id);

    List<Record> getLatest(int limit);

    Record create(Record newRecord);

    Record update(Record updatedRecord);

    void delete(Long id);
}
