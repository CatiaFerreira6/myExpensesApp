package com.cleancoder.myexpenses;

import android.arch.lifecycle.LiveData;

import com.cleancoder.myexpenses.db.ExpensesDatabase;
import com.cleancoder.myexpenses.db.entities.RecordWithEntities;

import java.util.List;

public class ExpensesRepository {

    private static ExpensesRepository sInstance;

    private final ExpensesDatabase mDatabase;

    private ExpensesRepository(final ExpensesDatabase database) {
        mDatabase = database;
    }

    public static ExpensesRepository getInstance(final ExpensesDatabase database) {
        if (sInstance == null) {
            synchronized (ExpensesRepository.class) {
                if (sInstance == null) {
                    sInstance = new ExpensesRepository(database);
                }
            }
        }
        return sInstance;
    }

    public LiveData<List<RecordWithEntities>> latestRecords(Long accountId) {
        return mDatabase.recordRepo().getLatest(accountId, 5);
    }
}