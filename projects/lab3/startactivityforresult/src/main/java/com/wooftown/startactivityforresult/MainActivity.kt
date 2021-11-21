package com.wooftown.startactivityforresult

import android.content.Intent
import android.os.Bundle
import com.wooftown.startactivityforresult.databinding.Fragment1Binding

// adb shell dumpsys activity activities | grep startactivityforresult | grep Hist

class MainActivity : OptionedActivity() {

    private lateinit var binging: Fragment1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = Fragment1Binding.inflate(layoutInflater)
        setContentView(binging.root)
        binging.bnToSecond.setOnClickListener { toSecond() }

    }


    private fun toSecond() {
        startActivity(Intent(this, SecondActivity::class.java))
    }


}