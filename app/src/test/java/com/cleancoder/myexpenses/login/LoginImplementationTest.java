package com.cleancoder.myexpenses.login;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginImplementationTest {

    private LoginContract login = new LoginImplementation();

    @Test
    public void validEmail() {
        assertTrue(login.validEmail("foo@example.com"));
        assertFalse(login.validEmail("fooexample.com"));
        assertFalse(login.validEmail(null));
    }

    @Test
    public void validPassword() {
        assertTrue(login.validPassword("hello"));
        assertFalse(login.validPassword("hell"));
        assertFalse(login.validPassword(null));
    }

    @Test
    public void login() {
        assertTrue(login.login("foo@example.com", "hello"));
        assertFalse(login.login("test@fail.com", "validPassword"));
        assertFalse(login.login("fooexample.com","hell"));
    }
}