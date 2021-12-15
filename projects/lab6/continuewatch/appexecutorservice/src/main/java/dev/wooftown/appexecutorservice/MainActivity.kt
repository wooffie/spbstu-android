package dev.wooftown.appexecutorservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import dev.wooftown.appexecutorservice.databinding.ActivityMainBinding
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future

class MainActivity : AppCompatActivity() {

    private var secondsElapsed: Int = 0
    private lateinit var textSecondsElapsed: TextView
    private lateinit var backgroundFuture: Future<*>

    private fun submitBackground(executorService: ExecutorService) = executorService.submit {
        while (!executorService.isShutdown) {
            Log.d(TAG, "${Thread.currentThread()} is iterating")
            Thread.sleep(1000)
            textSecondsElapsed.post {
                textSecondsElapsed.text = "${secondsElapsed++}"
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
        backgroundFuture = submitBackground((applicationContext as MyApplication).watchPool)
    }

    override fun onStop() {
        super.onStop()
        backgroundFuture.cancel(true)
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