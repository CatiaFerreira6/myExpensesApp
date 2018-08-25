package com.cleancoder.myexpenses;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule
            = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void testGreet() {
        onView(withId(R.id.email))
                .perform(typeText("foo@example.com"), closeSoftKeyboard());

        onView(withId(R.id.email))
                .check(matches(withText("foo@example.com")));

        onView(withId(R.id.password))
                .perform(typeText("hello"), closeSoftKeyboard());

        onView(withId(R.id.email_sign_in_button)).perform(click());

        onView(withId(R.id.latestRecords)).check(matches(isDisplayed()));
    }
}