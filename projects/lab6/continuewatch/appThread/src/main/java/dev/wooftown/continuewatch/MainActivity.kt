package dev.wooftown.continuewatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import dev.wooftown.continuewatch.databinding.ActivityMainBinding

// adb shell top -h
class MainActivity : AppCompatActivity() {

    private var secondsElapsed: Int = 0
    private lateinit var textSecondsElapsed: TextView

    private lateinit var backgroundThread: Thread

    private fun createNewThread() = Thread {
        try {
            while (!Thread.currentThread().isInterrupted) {
                Log.d(TAG, "${Thread.currentThread()} is iterating")
                Thread.sleep(1000)
                textSecondsElapsed.post {
                    textSecondsElapsed.text = "${secondsElapsed++}"
                }
            }
        } catch (e: InterruptedException) {
            Log.d(TAG, "${Thread.currentThread()} went catch block")
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
        Log.d("TAG", "onStart()")

        backgroundThread = createNewThread()
        backgroundThread.start()
        Log.d("TAG", "${backgroundThread.id}")

    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "onStop()")

        backgroundThread.interrupt()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.run {
            Log.d(TAG, "Saving state SEC=$secondsElapsed")
            putInt(SEC, secondsElapsed)
        }
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