package com.cleancoder.myexpenses.login;

import android.app.Application;

import com.cleancoder.myexpenses.App;
import com.cleancoder.myexpenses.db.entities.User;
import com.cleancoder.myexpenses.db.repositories.UserRepository;

public class LoginImplementation implements LoginContract {

    private UserRepository userRepository;

    public LoginImplementation(Application application){
        userRepository = ((App) application).getUserRepository();
    }

    @Override
    public boolean validEmail(String email){
        return email != null && !email.isEmpty() && email.contains("@");
    }

    public boolean validPassword(String password){
        return password != null && !password.isEmpty() && password.length() > 4;
    }

    @Override
    public User login(String email, String password) {
        if(validEmail(email) && validPassword(password)){
            return userExists(email, password);
        }

        return null;
    }

    private User userExists(String email, String password){
        User user = userRepository.getByEmail(email);

        if(user.password.equals(password)){
            return user;
        } else {
            return null;
        }
    }
}
