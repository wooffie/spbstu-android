package com.wooftown.intentflagsactivityattributes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.wooftown.intentflagsactivityattributes.OptionedActivity
import com.wooftown.intentflagsactivityattributes.SecondActivity
import com.wooftown.intentflagsactivityattributes.databinding.Fragment1Binding


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