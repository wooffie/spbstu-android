package com.wooftown.myapplication


import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var mainActivityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testActivityViews() {
        onView(withId(R.id.btn))
            .check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.edit_text))
            .check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun recreateWithFull() {
        onView(withId(R.id.edit_text)).perform(typeText(TEXT_TO_WRITE), closeSoftKeyboard())
        onView(withId(R.id.btn)).perform(click())

        onView(withId(R.id.edit_text)).check(matches(withText(TEXT_TO_WRITE)))
        onView(withId(R.id.btn)).check(matches(withText(R.string.cliked)))

        mainActivityRule.scenario.recreate()

        onView(withId(R.id.edit_text)).check(matches(withText(TEXT_TO_WRITE)))
        onView(withId(R.id.btn)).check(matches(withText(R.string.uncliked)))
    }

    @Test
    fun recreateWithEmpty() {
        onView(withId(R.id.edit_text)).perform(typeText(EMPTY_FIELD), closeSoftKeyboard())
        onView(withId(R.id.btn)).perform(click())

        onView(withId(R.id.edit_text)).check(matches(withText(EMPTY_FIELD)))
        onView(withId(R.id.btn)).check(matches(withText(R.string.cliked)))

        mainActivityRule.scenario.recreate()

        onView(withId(R.id.edit_text)).check(matches(withText(EMPTY_FIELD)))
        onView(withId(R.id.btn)).check(matches(withText(R.string.uncliked)))
    }

    @Test
    fun rotateWithFull() {
        onView(withId(R.id.edit_text)).perform(typeText(TEXT_TO_WRITE), closeSoftKeyboard())
        onView(withId(R.id.btn)).perform(click())

        onView(withId(R.id.edit_text)).check(matches(withText(TEXT_TO_WRITE)))
        onView(withId(R.id.btn)).check(matches(withText(R.string.cliked)))

        mainActivityRule.scenario.onActivity { activity ->
            activity.setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            )
        }
        Thread.sleep(1000)

        onView(withId(R.id.edit_text)).check(matches(withText(TEXT_TO_WRITE)))
        onView(withId(R.id.btn)).check(matches(withText(R.string.uncliked)))
    }

    @Test
    fun rotateWithEmpty() {
        onView(withId(R.id.edit_text)).perform(typeText(EMPTY_FIELD), closeSoftKeyboard())
        onView(withId(R.id.btn)).perform(click())

        onView(withId(R.id.edit_text)).check(matches(withText(EMPTY_FIELD)))
        onView(withId(R.id.btn)).check(matches(withText(R.string.cliked)))

        mainActivityRule.scenario.onActivity { activity ->
            activity.setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            )
        }
        Thread.sleep(1000)

        onView(withId(R.id.edit_text)).check(matches(withText(EMPTY_FIELD)))
        onView(withId(R.id.btn)).check(matches(withText(R.string.uncliked)))
    }

    companion object {
        const val TEXT_TO_WRITE = "Some text in EditText"
        const val EMPTY_FIELD = ""
    }


}