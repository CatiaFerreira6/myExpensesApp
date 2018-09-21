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
        Account account = new Account("111",2345d, "Primary Account");

        records.add(
                new Record(
                        account,
                        new SubCategory("ELECTRICAL","Electrical Bill", new Category("HOME", "Home", expenseType)),
                        new Date(),
                        -40.42,
                        "Electrical Bill"
                )
        );

        records.add(
                new Record(account,
                        new SubCategory("WATER","Water Bill", new Category("HOME", "Home", expenseType)),
                        new Date(),
                        -50.65,
                        "Water Bill"

                )
        );

        records.add(
                new Record(account,
                        new SubCategory("SALARY","Salary", new Category("SALARY", "Salary", incomeType)),
                        new Date(),
                        1000d,
                        "Monthly Salary"
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
