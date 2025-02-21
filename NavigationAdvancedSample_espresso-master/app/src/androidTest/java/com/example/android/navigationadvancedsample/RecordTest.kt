package com.example.android.navigationadvancedsample

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.AllOf
import org.junit.Rule
import org.junit.Test

@LargeTest
class RecordTest {
    @Rule
    var mActivityScenarioRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun recordTest() {
        val materialButton = Espresso.onView(
            AllOf.allOf(
                ViewMatchers.withId(R.id.about_btn), ViewMatchers.withText("About"),
                childAtPosition(
                    AllOf.allOf(
                        ViewMatchers.withId(R.id.title_constraint),
                        childAtPosition(
                            ViewMatchers.withId(R.id.nav_host_container),
                            0
                        )
                    ),
                    1
                ),
                ViewMatchers.isDisplayed()
            )
        )
        materialButton.perform(ViewActions.click())
        val textView = Espresso.onView(
            AllOf.allOf(
                ViewMatchers.withText("This sample showcases navigation using a Bottom Navigation View. The state and back stack of the three different screens are persisted."),
                ViewMatchers.withParent(
                    AllOf.allOf(
                        ViewMatchers.withId(R.id.title_constraint),
                        ViewMatchers.withParent(ViewMatchers.withId(R.id.nav_host_container))
                    )
                ),
                ViewMatchers.isDisplayed()
            )
        )
        textView.check(ViewAssertions.matches(ViewMatchers.withText("This sample showcases navigation using a Bottom Navigation View. The state and back stack of the three different screens are persisted.")))
        val bottomNavigationItemView = Espresso.onView(
            AllOf.allOf(
                ViewMatchers.withId(R.id.list), ViewMatchers.withContentDescription("Leaderboard"),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(R.id.bottom_nav),
                        0
                    ),
                    1
                ),
                ViewMatchers.isDisplayed()
            )
        )
        bottomNavigationItemView.perform(ViewActions.click())
        val recyclerView = Espresso.onView(
            AllOf.allOf(
                ViewMatchers.withId(R.id.leaderboard_list),
                childAtPosition(
                    ViewMatchers.withId(R.id.nav_host_container),
                    0
                )
            )
        )
        recyclerView.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                9,
                ViewActions.click()
            )
        )
        val textView2 = Espresso.onView(
            AllOf.allOf(
                ViewMatchers.withId(R.id.profile_user_name), ViewMatchers.withText("Person 10"),
                ViewMatchers.withParent(
                    AllOf.allOf(
                        ViewMatchers.withId(R.id.profiler_constraint_layout),
                        ViewMatchers.withParent(ViewMatchers.withId(R.id.nav_host_container))
                    )
                ),
                ViewMatchers.isDisplayed()
            )
        )
        textView2.check(ViewAssertions.matches(ViewMatchers.withText("Person 10")))
    }

    companion object {
        private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int
        ): Matcher<View> {
            return object : TypeSafeMatcher<View>() {
                override fun describeTo(description: Description) {
                    description.appendText("Child at position $position in parent ")
                    parentMatcher.describeTo(description)
                }

                public override fun matchesSafely(view: View): Boolean {
                    val parent = view.parent
                    return parent is ViewGroup && parentMatcher.matches(parent) && view == parent.getChildAt(
                        position
                    )
                }
            }
        }
    }
}
