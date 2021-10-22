package com.wooftown.intentflagsactivityattributes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.wooftown.intentflagsactivityattributes.databinding.FirstActivityBinding


// adb shell dumpsys activity activities | grep intentflagsactivityattributes | grep Hist
class FirstActivity : OptionedActivity() {

    private lateinit var binging: FirstActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = FirstActivityBinding.inflate(layoutInflater)
        setContentView(binging.root)
        binging.toSecond.setOnClickListener { toSecond() }

    }

    private fun toSecond() {
        startActivity(Intent(this, SecondActivity::class.java))
    }


}