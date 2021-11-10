package com.wooftown.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.wooftown.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binging = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binging.root)
        binging.btn.setOnClickListener {
            binging.btn.setText(R.string.cliked)
        }
    }

}