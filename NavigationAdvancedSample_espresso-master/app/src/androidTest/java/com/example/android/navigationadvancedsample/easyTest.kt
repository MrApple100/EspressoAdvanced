package com.example.android.navigationadvancedsample

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class easyTest {
    @Rule
    var activityActivityScenarioRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun checkTextOnGameTitle() {
        Espresso.onView(ViewMatchers.withId(R.id.game_title))
            .check(ViewAssertions.matches(ViewMatchers.withText("Welcome!")))
    }

    @Test
    fun checkTextOnTitleAbout() {
        Espresso.onView(ViewMatchers.withId(R.id.about_btn))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.about_tv))
            .check(ViewAssertions.matches(ViewMatchers.withText("About")))
    }

    @Test
    fun checkPictureOnDisplay() {
        Espresso.onView(ViewMatchers.withId(R.id.title_image))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun changeTextRegister() {
        Espresso.onView(ViewMatchers.withId(R.id.form))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.username_text))
            .perform(
                ViewActions.typeText("SashaSashaSashaSashaSashaSashaSashaSasha"),
                ViewActions.closeSoftKeyboard()
            )
            .check(ViewAssertions.matches(ViewMatchers.withText("SashaSashaSashaSashaSashaSashaSashaSasha")))
    }
}
