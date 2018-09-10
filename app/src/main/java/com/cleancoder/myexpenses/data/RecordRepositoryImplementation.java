package com.cleancoder.myexpenses.data;

import com.cleancoder.myexpenses.models.Account;
import com.cleancoder.myexpenses.models.Category;
import com.cleancoder.myexpenses.models.Record;
import com.cleancoder.myexpenses.models.SubCategory;
import com.cleancoder.myexpenses.models.Type;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordRepositoryImplementation implements RecordRepositoryContract {

    private List<Record> records = new ArrayList<>();

    public RecordRepositoryImplementation(){
        Type expenseType = new Type("EXPENSE", "Expense");
        Type incomeType = new Type("INCOME", "Income");
        Account account = new Account("111","Primary Account", 2345d);

        records.add(
                new Record(
                        new Category("HOME", "Home", expenseType),
                        new Type("EXPENSE", "Expense"),
                        new SubCategory("ELECTRICAL","Electrical Bill"),
                        account,
                        new Date(),
                        "Electrical Bill",
                        -40.42
                )
        );

        records.add(
                new Record(
                        new Category("HOME", "Home", expenseType),
                        new Type("EXPENSE", "Expense"),
                        new SubCategory("WATER","Water Bill"),
                        account,
                        new Date(),
                        "Water Bill",
                        -50.65
                )
        );

        records.add(
                new Record(
                        new Category("SALARY", "Salary", incomeType),
                        new Type("INCOME", "Income"),
                        null,
                        account,
                        new Date(),
                        "Monthly Salary",
                        1000d
                )
        );
    }

    public Record get(Long id){
        for(Record record : records) {
            if(record.getId().equals(id)) {
                return record;
            }
        }
        return null;
    }

    public List<Record> getLatest(int limit){
        if(limit >= records.size()){
            return records;
        } else {
            return records.subList(0, limit);
        }
    }

    public Record create(Record newRecord){
        records.add(newRecord);
        return newRecord;
    }

    public Record update(Record updatedRecord){
        //find record by id, update it and return it
        records.set(0, updatedRecord);
        return updatedRecord;
    }

    public void delete(Long id){
        //find record by id and remove it from list
        records.remove(0);
    }
}
