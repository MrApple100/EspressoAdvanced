package com.example.android.navigationadvancedsample

import android.content.Intent
import android.net.Uri
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test

class hardTest {
    private val userName = "Person 2"
    private val url: String

    @Rule
    var instantTaskExecutorRule: InstantTaskExecutorRule

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    init {
        url = "http://www.example.com/user/" + userName
        instantTaskExecutorRule = InstantTaskExecutorRule()

        // Устанавливаем интент для запуска активности
        val intent = Intent("android.intent.action.VIEW", Uri.parse(url))
        activityScenarioRule.scenario.onActivity { activity ->
            activity.intent = intent
        }
    }

    @Test
    fun bottomNavView_DeepLink_HandlesIntent_BackGoesToList() {
        // Opening the app with the proper Intent should start it in the profile screen.
        assertInProfile()
        Espresso.pressBack()

        // The list should be shown
        assertList()
        Espresso.pressBack()

        // Home destination should be shown
        assertInHome()
    }

    private fun assertInProfile() {
        Espresso.onView(ViewMatchers.withText(userName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun assertList() {
        Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withText(R.string.title_list),
                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.action_bar))
            )
        )
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun assertInHome() {
        Espresso.onView(ViewMatchers.withText(R.string.welcome))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
