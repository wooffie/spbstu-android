package com.wooftown.intentflagsactivityattributes

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Bundle
import com.wooftown.intentflagsactivityattributes.databinding.Fragment3Binding


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


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun toFirst() {
        val intent = Intent(this, MainActivity::class.java).addFlags(FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun toSecond() {
        finish()
    }


}