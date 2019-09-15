package com.cleancoder.myexpenses.login;

import android.content.Context;

import com.cleancoder.myexpenses.App;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginImplementationTest {

    @Mock
    Context mockContext;

    private LoginContract login = new LoginImplementation(new App());

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
        assertNotNull(login.login("foo@example.com", "hello"));
        assertNull(login.login("test@fail.com", "validPassword"));
        assertNull(login.login("fooexample.com","hell"));
    }
}