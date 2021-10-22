package com.wooftown.app2

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*
    STAY OF PAUSED:
    multi
    https://source.android.com/devices/tech/display/multi_display/multi-resume?hl=en

    another activity
    assistant

    more
    ?
*/

/*
two ways:
onResume onPause - app in full focus of device

onStart onStop - app visible for user
 */


class MainActivity : AppCompatActivity() {
    private var secondsElapsed: Int = 0
    private lateinit var textSecondsElapsed: TextView
    private lateinit var sharedPref: SharedPreferences

    private var visibility = false
        set(value) {
            field = value
            if (value) {
                secondsElapsed = sharedPref.getInt(SEC, 0)
                Log.d(TAG, "get $secondsElapsed from SEC of sharedPref")

                Log.d(TAG, "visibility == TRUE")
            } else {
                with(sharedPref.edit()) {
                    putInt(SEC, secondsElapsed)
                    apply()
                    Log.d(TAG, "put $secondsElapsed to SEC of sharedPref")
                }

                Log.d(TAG, "visibility == FALSE")
            }
        }


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
        Log.d(TAG, "onCreate()")
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.SecondsElapsed)
        sharedPref = getSharedPreferences(SEC, Context.MODE_PRIVATE)
        backgroundThread.start()

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart()")
        if (GOOD) {
            visibility = true // GOOD
        }

    }

    override fun onResume() {
        Log.d(TAG, "onResume()")
        super.onResume()
        if (!GOOD) {
            visibility = true // was BAD, use with onPause()
        }
    }


    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop()")
        visibility = false // GOOD
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause()")

        // visibility = false // good for focus
    }


    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }

    companion object {
        const val GOOD = true
        const val TAG = "ContWatch"
        const val SEC = "secondsElapsed"
    }

}
