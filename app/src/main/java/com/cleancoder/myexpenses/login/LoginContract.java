package com.cleancoder.myexpenses.login;

import com.cleancoder.myexpenses.db.entities.User;

public interface LoginContract {

    boolean validPassword(String password);

    boolean validEmail(String email);

    User login(String email, String password);
}
