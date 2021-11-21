package com.wooftown.startactivityforresult

import android.app.Activity
import android.os.Bundle
import com.wooftown.startactivityforresult.databinding.Fragment3Binding


class ThirdActivity : OptionedActivity() {


    private lateinit var binging: Fragment3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = Fragment3Binding.inflate(layoutInflater)
        setContentView(binging.root)
        binging.bnToFirst.setOnClickListener { toFirst() }
        binging.bnToSecond.setOnClickListener { toSecond() }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    private fun toFirst() {
        this.setResult(Activity.RESULT_OK)
        finish()
    }

    private fun toSecond() {
        finish()
    }


}