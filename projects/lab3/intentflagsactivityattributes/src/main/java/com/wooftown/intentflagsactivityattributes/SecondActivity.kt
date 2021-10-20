package com.wooftown.intentflagsactivityattributes

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.wooftown.intentflagsactivityattributes.databinding.SecondActivityBinding


class SecondActivity : OptionedActivity() {

    private lateinit var binging: SecondActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binging.root)
        binging.toFirst.setOnClickListener { toFirst() }
        binging.toThird.setOnClickListener { toThird() }
    }

    private fun toFirst() {
        finish()
    }

    private fun toThird() {
        startActivity(Intent(this, ThirdActivity::class.java))
    }


}