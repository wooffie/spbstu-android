package com.wooftown.intentflagsactivityattributes


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId


/**
 * looking beautiful, maybe bad for normal projects, can private then, etc
 */
fun assertViewWithId(viewId: Int) {
    onView(withId(viewId))
        .check(matches(isDisplayed()))
}

fun performClickWithId(viewId: Int) {
    onView(withId(viewId)).perform(click())
}