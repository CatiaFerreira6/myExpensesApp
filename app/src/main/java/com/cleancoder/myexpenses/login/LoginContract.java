package com.cleancoder.myexpenses.login;

public interface LoginContract {

    boolean validPassword(String password);

    boolean validEmail(String email);

    boolean login(String email, String password);
}
