package dev.wooftown.appcoroutines

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dev.wooftown.appcoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

class MainActivity : AppCompatActivity() {

    private var secondsElapsed: Int = 0
    private lateinit var textSecondsElapsed: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        textSecondsElapsed = binding.SecondsElapsed
        setContentView(binding.root)

        lifecycleScope.launchWhenResumed {
            while (isActive) {
                Log.d(TAG, "Coroutine works")
                delay(1000)
                textSecondsElapsed.post {
                    textSecondsElapsed.text = "${secondsElapsed++}"
                }
            }
        }

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