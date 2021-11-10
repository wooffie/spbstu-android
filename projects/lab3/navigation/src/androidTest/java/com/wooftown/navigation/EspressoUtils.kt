package com.wooftown.navigation



import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId

fun assertViewWithId(viewId: Int) {
    onView(withId(viewId))
        .check(matches(isDisplayed()))
}

fun performClickWithId(viewId: Int) {
    onView(withId(viewId)).perform(click())
}