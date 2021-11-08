package com.example.myapplication

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

// TODO() check with rotating screen
@RunWith(AndroidJUnit4::class)
class RecreateTest {

    @get:Rule
    val mainActivityRule = ActivityScenarioRule(MainActivity::class.java)

    // может быть включить проверку на наличие кнопок на экране после пересоздания,
    // или их отсутсвия в альт ресурсе другой ориентации

    @Test
    fun fromFragment1() {
        // Start of test - on display first Frag
        assertViewWithId(R.id.fragment1)
        mainActivityRule.scenario.recreate()
        assertViewWithId(R.id.fragment1)
    }

    @Test
    fun fromFragment2_3() {
        performClickWithId(R.id.bnToSecond)
        mainActivityRule.scenario.recreate()
        assertViewWithId(R.id.fragment2)
        performClickWithId(R.id.bnToThird)
        assertViewWithId(R.id.fragment3)
    }

    @Test
    fun fromFragment2_1() {
        performClickWithId(R.id.bnToSecond)
        mainActivityRule.scenario.recreate()
        assertViewWithId(R.id.fragment2)
        performClickWithId(R.id.bnToFirst)
        assertViewWithId(R.id.fragment1)
    }

    @Test
    fun fromFragment3_1() {
        performClickWithId(R.id.bnToSecond)
        performClickWithId(R.id.bnToThird)
        mainActivityRule.scenario.recreate()
        assertViewWithId(R.id.fragment3)
        performClickWithId(R.id.bnToFirst)
        assertViewWithId(R.id.fragment1)
    }

    @Test
    fun fromFragment3_2() {
        performClickWithId(R.id.bnToSecond)
        performClickWithId(R.id.bnToThird)
        mainActivityRule.scenario.recreate()
        assertViewWithId(R.id.fragment3)
        performClickWithId(R.id.bnToSecond)
        assertViewWithId(R.id.fragment2)
    }


}