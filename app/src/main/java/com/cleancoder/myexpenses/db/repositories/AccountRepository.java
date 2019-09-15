package com.cleancoder.myexpenses.db.repositories;

import android.os.AsyncTask;

import com.cleancoder.myexpenses.db.ExpensesDatabase;
import com.cleancoder.myexpenses.db.dao.AccountRepositoryContract;
import com.cleancoder.myexpenses.db.dao.UserRepositoryContract;
import com.cleancoder.myexpenses.db.entities.Account;
import com.cleancoder.myexpenses.db.entities.User;

public class AccountRepository {

    private static AccountRepository sInstance;

    private final ExpensesDatabase mDatabase;

    private AccountRepository(final ExpensesDatabase database) {
        mDatabase = database;
    }

    public static AccountRepository getInstance(final ExpensesDatabase database) {
        if (sInstance == null) {
            synchronized (AccountRepository.class) {
                if (sInstance == null) {
                    sInstance = new AccountRepository(database);
                }
            }
        }
        return sInstance;
    }

    public Account get(Long id) {return mDatabase.accountRepo().get(id); }

    public Account get(String number){
        return mDatabase.accountRepo().get(number);
    }

    public void create(Account account){
        new insertAsyncTask(mDatabase.accountRepo()).execute(account);
    }

    private static class insertAsyncTask extends AsyncTask<Account, Void, Account> {

        private AccountRepositoryContract accountRepo;

        insertAsyncTask(AccountRepositoryContract dao) {
            accountRepo = dao;
        }

        @Override
        protected Account doInBackground(final Account... params) {
            Long id = accountRepo.create(params[0]);
            params[0].id = id;

            return params[0];
        }
    }

    public void update(Account account){
        new updateAsyncTask(mDatabase.accountRepo()).execute(account);
    }

    private static class updateAsyncTask extends AsyncTask<Account, Void, Account> {

        private AccountRepositoryContract accountRepo;

        updateAsyncTask(AccountRepositoryContract dao) {
            accountRepo = dao;
        }

        @Override
        protected Account doInBackground(final Account... params) {
            if(accountRepo.update(params[0]) > 0){
                return params[0];
            } else {
                return null;
            }
        }
    }

    public void delete(Account account){
        new deleteAsyncTask(mDatabase.accountRepo()).execute(account);
    }

    private static class deleteAsyncTask extends AsyncTask<Account, Void, Boolean> {

        private AccountRepositoryContract accountRepo;

        deleteAsyncTask(AccountRepositoryContract dao) {
            accountRepo = dao;
        }

        @Override
        protected Boolean doInBackground(final Account... params) {
            if(accountRepo.delete(params[0]) > 0){
                return true;
            } else {
                return false;
            }
        }
    }
}
