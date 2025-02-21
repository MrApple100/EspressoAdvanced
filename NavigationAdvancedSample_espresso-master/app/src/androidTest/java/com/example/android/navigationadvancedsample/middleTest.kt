package com.example.android.navigationadvancedsample

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class middleTest {
    @Rule
    var rule = ActivityTestRule(MainActivity::class.java, true, false)
    @Test
    fun demonstrateIntentPrep() {
        val intent = Intent()
        intent.putExtra("EXTRA", "Test")
        rule.launchActivity(intent)
        Espresso.onView(ViewMatchers.withId(R.id.game_title))
            .check(ViewAssertions.matches(ViewMatchers.withText("Test")))
    }

    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        val activity = rule.activity
        activity.myString
        // do more
    }


    @Test
    @Throws(Exception::class)
    fun ensureListViewIsPresent() {
        Espresso.onData(Matchers.hasToString(Matchers.containsString("Frodo")))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText(Matchers.startsWith("Clicked:"))).inRoot(
            RootMatchers.withDecorView(
                Matchers.not(Matchers.`is`(rule.activity.window.decorView))
            )
        ).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
