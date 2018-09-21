package com.cleancoder.myexpenses.data;

import com.cleancoder.myexpenses.models.Account;
import com.cleancoder.myexpenses.models.Category;
import com.cleancoder.myexpenses.models.Record;
import com.cleancoder.myexpenses.models.SubCategory;
import com.cleancoder.myexpenses.models.Type;

import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class RecordRepositoryImplementationTest {

    private RecordRepositoryImplementation recordRepo = new RecordRepositoryImplementation();

    Type expenseType = new Type("EXPENSE", "Expense");

    @Test
    public void get() {
        Record record = recordRepo.get(0L);

        assertEquals(record.value, Double.valueOf(-40.42d));

        record = recordRepo.get(50L);

        assertNull(record);
    }

    @Test
    public void getLatest() {
        List<Record> records = recordRepo.getLatest(5);

        assertEquals(records.size(), 3);

        records = recordRepo.getLatest(1);

        assertEquals(records.size(), 1);
    }

    @Test
    public void create() {
        Record newRecord = new Record(
                new Category("HOME", "Home", expenseType),
                new Type("EXPENSE", "Expense"),
                new SubCategory("ELECTRICAL","Electrical Bill", new Category("HOME", "Home", expenseType)),
                new Account("111","Primary Account", 2345d),
                new Date(),
                "Electrical Bill",
                -100d
        );

        Record createdRecord = recordRepo.create(newRecord);

        assertEquals(createdRecord, newRecord);
    }

    @Test
    public void update() {
        Record oldRecord = recordRepo.get(0L);

        oldRecord.value = -200d;

        Record updatedRecord = recordRepo.update(oldRecord);

        assertEquals(updatedRecord.value, Double.valueOf(-200d));
    }

    @Test
    public void delete() {
        int recordSize = recordRepo.getLatest(5).size();

        recordRepo.delete(0L);

        List<Record> newRecords = recordRepo.getLatest(5);
        System.out.println(newRecords.toString());

        assertEquals(recordSize - 1, newRecords.size());
    }
}