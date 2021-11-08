package com.example.myapplication

import androidx.test.espresso.Espresso.pressBack
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Testing for correct navigation through app
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @get:Rule
    val mainActivityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun fromFragment1() {
        // Start of test - on display first Frag
        assertViewWithId(R.id.fragment1)

        // Check opening About Activity
        openAbout() // Nav Frag1 -> About
        assertViewWithId(R.id.activity_about)

        // Check pressing back - we should go in Frag1
        pressBack()
        assertViewWithId(R.id.fragment1)

        performClickWithId(R.id.bnToSecond) // Nav Frag1 -> Frag2
        assertViewWithId(R.id.fragment2)
        //assertView(R.id.activity_main)
    }

    @Test
    fun fromFragment2() {
        // Fact about first view - is Frag1 was aproved in upper test
        performClickWithId(R.id.bnToSecond)
        assertViewWithId(R.id.fragment2) // maybe not needed, was in test1

        openAbout()
        assertViewWithId(R.id.activity_about) // Nav Frag2 -> About
        pressBack()
        assertViewWithId(R.id.fragment2)

        performClickWithId(R.id.bnToFirst) // Nav Frag2 -> Frag1
        assertViewWithId(R.id.fragment1)
        performClickWithId(R.id.bnToSecond)
        assertViewWithId(R.id.fragment2)

        performClickWithId(R.id.bnToThird) // Nav Frag2 -> Frag3
        assertViewWithId(R.id.fragment3)
    }

    @Test
    fun fromFragment3() {
        // This navs tested before, we know - start at Frag3
        performClickWithId(R.id.bnToSecond)
        performClickWithId(R.id.bnToThird)
        assertViewWithId(R.id.fragment3) // maybe not needed, was in test2

        openAbout()
        assertViewWithId(R.id.activity_about) // Nav Frag3 -> About
        pressBack()
        assertViewWithId(R.id.fragment3)

        performClickWithId(R.id.bnToSecond) // Nav Frag3 -> Frag2
        assertViewWithId(R.id.fragment2)
        performClickWithId(R.id.bnToThird)
        assertViewWithId(R.id.fragment3)

        performClickWithId(R.id.bnToFirst) // Nav Frag3 -> Frag1
        assertViewWithId(R.id.fragment1)


    }

}