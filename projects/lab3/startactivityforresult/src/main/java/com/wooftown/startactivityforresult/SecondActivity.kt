package com.wooftown.startactivityforresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.wooftown.startactivityforresult.databinding.FirstActivityBinding
import com.wooftown.startactivityforresult.databinding.SecondActivityBinding

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_CODE && resultCode == Activity.RESULT_OK) {
            finish()
        }
    }

    private fun toThird() {
        startActivityForResult(Intent(this, ThirdActivity::class.java), RESULT_CODE)
    }


    companion object {
        const val RESULT_CODE = 0
    }

}