package com.cleancoder.myexpenses.login;

import java.util.ArrayList;

public class LoginImplementation implements LoginContract {

    private ArrayList<String> userData = new ArrayList<>();

    public LoginImplementation(){
        userData.add("foo@example.com:hello");
        userData.add("bar@example.com:hello");
    }

    @Override
    public boolean validEmail(String email){
        return email != null && !email.isEmpty() && email.contains("@");
    }

    public boolean validPassword(String password){
        return password != null && !password.isEmpty() && password.length() > 4;
    }

    @Override
    public boolean login(String email, String password) {
        return (validEmail(email) && validPassword(password) && userExists(email, password));
    }

    private boolean userExists(String email, String password){
        for(String user: userData){
            String[] creds = user.split(":");
            if(creds[0].equals(email) && creds[1].equals(password)){
                return true;
            }
        }

        return false;
    }
}
