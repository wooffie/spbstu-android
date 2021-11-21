package dev.wooftown.continuewatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import dev.wooftown.continuewatch.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var secondsElapsed: Int = 0
    private lateinit var textSecondsElapsed: TextView

    private var backgroundThread = Thread {
        while (!Thread.currentThread().isInterrupted) {
            Log.d(TAG, "${Thread.currentThread()} is iterating")
            try {
                Thread.sleep(1000)
                textSecondsElapsed.post {
                    textSecondsElapsed.text = "${secondsElapsed++}"
                }
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        textSecondsElapsed = binding.SecondsElapsed
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        backgroundThread.start()
    }

    override fun onStop() {
        super.onStop()
        backgroundThread.interrupt()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            Log.d(TAG, "Saving state SEC=$secondsElapsed")
            putInt(SEC, secondsElapsed)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.run {
            secondsElapsed = getInt(SEC)
            Log.d(TAG, "Restore state SEC=$secondsElapsed")
        }
    }

    companion object {
        const val TAG = "ContWatch"
        const val SEC = "secondsElapsed"
    }
}