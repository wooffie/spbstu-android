package com.wooftown.intentflagsactivityattributes

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AboutTest {

    @get:Rule
    var mainActivityRule = ActivityScenarioRule(MainActivity::class.java)


    private fun navAppClickUp() {
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description))
            .perform(click())
    }


    @Test
    fun frag1_back() {
        launchActivity<MainActivity>()
        openAbout()
        pressBackUnconditionally()
        pressBackUnconditionally()
        Assert.assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun frag1_up() {
        launchActivity<MainActivity>()
        openAbout()
        navAppClickUp()
        pressBackUnconditionally()
        Assert.assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun frag2_back() {
        launchActivity<MainActivity>()
        performClickWithId(R.id.bnToSecond)
        openAbout()
        pressBackUnconditionally()
        assertViewWithId(R.id.fragment2)
        pressBackUnconditionally()
        assertViewWithId(R.id.fragment1)
        pressBackUnconditionally()
        Assert.assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }


    @Test
    fun frag2_up() {
        launchActivity<MainActivity>()
        performClickWithId(R.id.bnToSecond)
        openAbout()
        navAppClickUp()
        assertViewWithId(R.id.fragment2)
        pressBackUnconditionally()
        assertViewWithId(R.id.fragment1)
        pressBackUnconditionally()
        Assert.assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }


    @Test
    fun frag3_back_backs() {
        launchActivity<MainActivity>()
        performClickWithId(R.id.bnToSecond)
        performClickWithId(R.id.bnToThird)
        openAbout()
        pressBackUnconditionally()
        assertViewWithId(R.id.fragment3)
        pressBackUnconditionally()
        assertViewWithId(R.id.fragment2)
        pressBackUnconditionally()
        assertViewWithId(R.id.fragment1)
        pressBackUnconditionally()
        Assert.assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }


    @Test
    fun frag3_up_backs() {
        launchActivity<MainActivity>()
        performClickWithId(R.id.bnToSecond)
        performClickWithId(R.id.bnToThird)
        openAbout()
        navAppClickUp()
        assertViewWithId(R.id.fragment3)
        pressBackUnconditionally()
        assertViewWithId(R.id.fragment2)
        pressBackUnconditionally()
        assertViewWithId(R.id.fragment1)
        pressBackUnconditionally()
        Assert.assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }


    @Test
    fun frag3_back_toFirst() {
        launchActivity<MainActivity>()
        performClickWithId(R.id.bnToSecond)
        performClickWithId(R.id.bnToThird)
        openAbout()
        pressBackUnconditionally()
        assertViewWithId(R.id.fragment3)
        performClickWithId(R.id.bnToFirst)
        assertViewWithId(R.id.fragment1)
        pressBackUnconditionally()
        Assert.assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun frag3_up_toFirst() {
        launchActivity<MainActivity>()
        performClickWithId(R.id.bnToSecond)
        performClickWithId(R.id.bnToThird)
        openAbout()
        navAppClickUp()
        assertViewWithId(R.id.fragment3)
        performClickWithId(R.id.bnToFirst)
        assertViewWithId(R.id.fragment1)
        pressBackUnconditionally()
        Assert.assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }


    @Test
    fun frag3_back_buttons() {
        launchActivity<MainActivity>()
        performClickWithId(R.id.bnToSecond)
        performClickWithId(R.id.bnToThird)
        openAbout()
        pressBackUnconditionally()
        assertViewWithId(R.id.fragment3)
        performClickWithId(R.id.bnToSecond)
        assertViewWithId(R.id.fragment2)
        pressBackUnconditionally()
        assertViewWithId(R.id.fragment1)
        pressBackUnconditionally()
        Assert.assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun frag3_up_buttons() {
        launchActivity<MainActivity>()
        performClickWithId(R.id.bnToSecond)
        performClickWithId(R.id.bnToThird)
        openAbout()
        navAppClickUp()
        assertViewWithId(R.id.fragment3)
        performClickWithId(R.id.bnToSecond)
        assertViewWithId(R.id.fragment2)
        pressBackUnconditionally()
        assertViewWithId(R.id.fragment1)
        pressBackUnconditionally()
        Assert.assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }


}