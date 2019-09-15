package com.cleancoder.myexpenses.db.repositories;

import android.os.AsyncTask;

import com.cleancoder.myexpenses.db.ExpensesDatabase;
import com.cleancoder.myexpenses.db.dao.UserRepositoryContract;
import com.cleancoder.myexpenses.db.entities.User;

public class UserRepository {

    private static UserRepository sInstance;

    private final ExpensesDatabase mDatabase;

    private UserRepository(final ExpensesDatabase database) {
        mDatabase = database;
    }

    public static UserRepository getInstance(final ExpensesDatabase database) {
        if (sInstance == null) {
            synchronized (UserRepository.class) {
                if (sInstance == null) {
                    sInstance = new UserRepository(database);
                }
            }
        }
        return sInstance;
    }

    public User get(Long id){
        return mDatabase.userRepo().get(id);
    }

    public User get(String username){
        return mDatabase.userRepo().get(username);
    }

    public User getWithAccount(String username){
        return mDatabase.userRepo().getWithAccount(username);
    }

    public User getByEmail(String email){
        return mDatabase.userRepo().getByEmail(email);
    }

    public void create(User user){
        new insertAsyncTask(mDatabase.userRepo()).execute(user);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, User> {

        private UserRepositoryContract userRepo;

        insertAsyncTask(UserRepositoryContract dao) {
            userRepo = dao;
        }

        @Override
        protected User doInBackground(final User... params) {
            Long id = userRepo.create(params[0]);
            params[0].id = id;

            return params[0];
        }
    }

    public void update(User user){
        new updateAsyncTask(mDatabase.userRepo()).execute(user);
    }

    private static class updateAsyncTask extends AsyncTask<User, Void, User> {

        private UserRepositoryContract userRepo;

        updateAsyncTask(UserRepositoryContract dao) {
            userRepo = dao;
        }

        @Override
        protected User doInBackground(final User... params) {
            if(userRepo.update(params[0]) > 0) {
                return params[0];
            } else {
                return null;
            }
        }
    }

    public void delete(User user){
        new deleteAsyncTask(mDatabase.userRepo()).execute(user);
    }

    private static class deleteAsyncTask extends AsyncTask<User, Void, Boolean> {

        private UserRepositoryContract userRepo;

        deleteAsyncTask(UserRepositoryContract dao) {
            userRepo = dao;
        }

        @Override
        protected Boolean doInBackground(final User... params) {
            if(userRepo.delete(params[0]) > 0){
                return true;
            } else {
                return false;
            }
        }
    }
}
