package com.wooftown.startactivityforresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.wooftown.startactivityforresult.databinding.ThirdActivityBinding

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
        this.setResult(Activity.RESULT_OK)
        finish()
    }

    private fun toSecond() {
        finish()
    }


}