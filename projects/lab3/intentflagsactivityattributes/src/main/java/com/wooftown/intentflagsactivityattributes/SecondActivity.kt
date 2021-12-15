package com.wooftown.intentflagsactivityattributes

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.wooftown.intentflagsactivityattributes.databinding.Fragment2Binding


class SecondActivity : OptionedActivity() {

    private lateinit var binging: Fragment2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = Fragment2Binding.inflate(layoutInflater)
        setContentView(binging.root)
        binging.bnToFirst.setOnClickListener { toFirst() }
        binging.bnToThird.setOnClickListener { toThird() }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun toFirst() {
        finish()
    }

    private fun toThird() {
        startActivity(Intent(this, ThirdActivity::class.java))
    }


}