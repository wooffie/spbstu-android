package com.wooftown.startactivityforresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.wooftown.startactivityforresult.databinding.Fragment2Binding


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