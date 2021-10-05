package ru.spbstu.icc.kspt.lab2.continuewatch

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var secondsElapsed: Int = 0
    private lateinit var textSecondsElapsed: TextView
    private var visibility = false

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

        override fun onSaveInstanceState(outState: Bundle) {
            outState.run {
                Log.d(TAG,"Saving state SEC=$secondsElapsed")
                putInt(SEC,secondsElapsed)
            }
            super.onSaveInstanceState(outState)
        }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.run {
            secondsElapsed = getInt(SEC)
            Log.d(TAG,"Restore state SEC=$secondsElapsed")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.SecondsElapsed)
        backgroundThread.start()
    }

    override fun onStop() {
        super.onStop()
        visibility = false
        Log.d(TAG,"visibility == FALSE")

    }

    override fun onResume() {
        super.onResume()
        visibility = true
        Log.d(TAG,"visibility == TRUE")

    }

    companion object{
        const val TAG = "ContWatch"
        const val SEC = "secondsElapsed"
    }

}
