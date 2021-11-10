package com.example.myapplication

import android.view.Gravity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openContextualActionModeOverflowMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.contrib.NavigationViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.wooftown.startactivityforresult.R


private fun openAboutViaOptions() {
    openContextualActionModeOverflowMenu()
    onView(withText(R.string.title_about))
        .perform(click())
}


fun openAbout() = openAboutViaOptions()