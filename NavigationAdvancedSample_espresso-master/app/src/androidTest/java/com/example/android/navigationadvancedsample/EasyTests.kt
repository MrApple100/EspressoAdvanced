package com.example.android.navigationadvancedsample

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//@RunWith(AndroidJUnit4::class)
class EasyTests {

 //   var rule = ActivityTestRule(MainActivity::class.java, true, false)

    @JvmField
    @Rule
    public var activityScenarioRule = ActivityScenarioRule<MainActivity>(MainActivity::class.java)

    @Test
    fun checkTextOnTitle(){
        Espresso.onView(ViewMatchers.withId(R.id.game_title))
            .check(ViewAssertions.matches(ViewMatchers.withText("Welcome!")))
    }
    @Test
    fun checkTextOnTitleAbout(){
        Espresso.onView(ViewMatchers.withId(R.id.about_btn))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.about_tv))
            .check(ViewAssertions.matches(ViewMatchers.withText("About")))
    }

    @Test
    fun checkTextRegistered(){
        Espresso.onView(ViewMatchers.withId(R.id.form))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withHint("Name"))
            .perform(ViewActions.typeText("SashaSashaSashaSashaSashaSashaSasha"),
                ViewActions.closeSoftKeyboard())
            .check(ViewAssertions.matches(ViewMatchers.withText("SashaSashaSashaSashaSashaSashaSasha")))
    }

}