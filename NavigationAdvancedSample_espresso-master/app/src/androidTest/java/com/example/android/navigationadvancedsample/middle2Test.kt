package com.example.android.navigationadvancedsample

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class middle2Test {
    @Rule
    var activityActivityScenarioRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun changeTextRegister() {
        Espresso.onView(ViewMatchers.withId(R.id.form))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.username_text))
            .perform(ViewActions.typeText("123"), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.signup_btn))
            .perform(ViewActions.click())
        Espresso.pressBack()
        Espresso.onView(ViewMatchers.withId(R.id.username_text))
            .check(ViewAssertions.matches(ViewMatchers.withText("123")))
    }
}
