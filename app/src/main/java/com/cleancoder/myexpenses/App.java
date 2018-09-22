package com.cleancoder.myexpenses;

import android.app.Application;

import com.cleancoder.myexpenses.db.ExpensesDatabase;
import com.cleancoder.myexpenses.db.entities.User;
import com.cleancoder.myexpenses.db.repositories.AccountRepository;
import com.cleancoder.myexpenses.db.repositories.UserRepository;

public class App extends Application{

    private AppExecutors mAppExecutors;

    private static User currentUser;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppExecutors = new AppExecutors();
    }


    public static User getCurrentUser(){
        return currentUser;
    }
    public static void setCurrentUser(User user){
        currentUser = user;
    }

    public ExpensesDatabase getDatabase() {
        return ExpensesDatabase.getDatabase(this, mAppExecutors);
    }

    public UserRepository getUserRepository() {
        return UserRepository.getInstance(getDatabase());
    }

    public AccountRepository getAccountRepository() {
        return AccountRepository.getInstance(getDatabase());
    }
}
