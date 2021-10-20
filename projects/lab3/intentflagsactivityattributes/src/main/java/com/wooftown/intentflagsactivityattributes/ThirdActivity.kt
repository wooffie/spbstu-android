package com.wooftown.intentflagsactivityattributes

import android.app.Activity
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.wooftown.intentflagsactivityattributes.databinding.ThirdActivityBinding


class ThirdActivity : OptionedActivity() {


    private lateinit var binging: ThirdActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = ThirdActivityBinding.inflate(layoutInflater)
        setContentView(binging.root)
        binging.toFirst.setOnClickListener { toFirst() }
        binging.toSecond.setOnClickListener { toSecond() }
    }

    private fun toFirst() {
        val intent = Intent(this, FirstActivity::class.java).addFlags(FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun toSecond() {
        finish()
    }


}