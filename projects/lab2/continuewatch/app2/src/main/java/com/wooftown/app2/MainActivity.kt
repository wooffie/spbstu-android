package com.wooftown.app2

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var secondsElapsed: Int = 0
    private lateinit var textSecondsElapsed: TextView
    private var visibility = false
    private lateinit var sharedPref: SharedPreferences

    private var backgroundThread = Thread {
        while (true) {
            if (visibility) {
                Thread.sleep(1000)
                textSecondsElapsed.post {
                    textSecondsElapsed.text = "${secondsElapsed++}"
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.SecondsElapsed)
        sharedPref = getSharedPreferences(SEC, Context.MODE_PRIVATE)
        backgroundThread.start()

    }

    override fun onStop() {
        super.onStop()
        visibility = false
        with(sharedPref.edit()) {
            Log.d(TAG, "put $secondsElapsed to SEC of sharedPref")
            putInt(SEC, secondsElapsed)
            apply()
        }
        Log.d(TAG, "visibility == FALSE")

    }

    override fun onResume() {
        super.onResume()
        visibility = true
        secondsElapsed = sharedPref.getInt(SEC, 0)
        Log.d(TAG, "get $secondsElapsed from SEC of sharedPref")
        Log.d(TAG, "visibility == TRUE")

    }

    companion object {
        const val TAG = "ContWatch"
        const val SEC = "secondsElapsed"
    }

}
