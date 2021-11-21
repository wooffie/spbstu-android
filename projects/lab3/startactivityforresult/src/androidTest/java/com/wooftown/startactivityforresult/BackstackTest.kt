package com.example.myapplication

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.wooftown.startactivityforresult.MainActivity
import com.wooftown.startactivityforresult.R
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/*
 *  Может быть тут надо больше вариантов... TODO()
 */
@RunWith(AndroidJUnit4::class)
class BackstackTest {

    @get:Rule
    var mainActivityRule = ActivityScenarioRule(MainActivity::class.java)

    // We know - 100% first Frag is start Frag

    @Test
    fun exitFromFrag1() {
        launchActivity<MainActivity>()
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun exitFromFrag1_Frag2_1() {
        launchActivity<MainActivity>() // Frag1 -> Frag2 -> Frag1 b> exit
        performClickWithId(R.id.bnToSecond)
        performClickWithId(R.id.bnToFirst)
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun exitFromFrag1_Frag2_2() {
        launchActivity<MainActivity>() // Frag1 -> Frag2 b> Frag1 b> exit
        performClickWithId(R.id.bnToSecond)
        pressBackUnconditionally()
        assertViewWithId(R.id.fragment1)
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun exitFromFrag1_Frag3_1() {
        launchActivity<MainActivity>() // Frag1 -> Frag2 -> Frag3 -> Frag1 b> exit
        performClickWithId(R.id.bnToSecond)
        performClickWithId(R.id.bnToThird)
        performClickWithId(R.id.bnToFirst)
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun exitFromFrag1_Frag3_2() {
        launchActivity<MainActivity>() // Frag1 -> Frag2 -> Frag3 -> Frag2 b> Frag1 b> exit
        performClickWithId(R.id.bnToSecond)
        performClickWithId(R.id.bnToThird)
        performClickWithId(R.id.bnToSecond)
        pressBackUnconditionally()
        assertViewWithId(R.id.fragment1)
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun exitFromFrag1_Frag3_3() {
        launchActivity<MainActivity>() // Frag1 -> Frag2 -> Frag3 b> Frag2 b> Frag1 b> exit
        performClickWithId(R.id.bnToSecond)
        performClickWithId(R.id.bnToThird)
        pressBackUnconditionally()
        assertViewWithId(R.id.fragment2)
        pressBackUnconditionally()
        assertViewWithId(R.id.fragment1)
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun exitFromFrag1_Frag3_4() {
        launchActivity<MainActivity>() // Frag1 -> Frag2 -> Frag3 b> Frag2 -> Frag1 b> exit
        performClickWithId(R.id.bnToSecond)
        performClickWithId(R.id.bnToThird)
        pressBackUnconditionally()
        assertViewWithId(R.id.fragment2)
        performClickWithId(R.id.bnToFirst)
        assertViewWithId(R.id.fragment1)
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    // Backstack with ABOUT will checked in different test cases

}