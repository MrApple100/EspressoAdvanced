package com.example.android.navigationadvancedsample

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class EasyTest2 {

    @JvmField
    @Rule
    public var activityScenarioRule =
        ActivityScenarioRule<MainActivity>(MainActivity::class.java)

    @Test
    fun testTitle(){
        Espresso.onView(ViewMatchers.withId(R.id.game_title))
            .check(ViewAssertions.matches(ViewMatchers.withText("Welcome!")))
    }
}