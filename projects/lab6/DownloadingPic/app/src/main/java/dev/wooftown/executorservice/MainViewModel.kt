package dev.wooftown.executorservice

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.net.URL
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class MainViewModel : ViewModel() {

    val bitmap: MutableLiveData<Bitmap> = MutableLiveData()

    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    fun downloadImage(url: URL) {
        executorService.execute {
            Log.d(TAG, "Sleeping 5sec")
            Thread.sleep(5000)
            Log.d(TAG, "Downloading in ${Thread.currentThread()}")
            bitmap.postValue(BitmapFactory.decodeStream(url.openConnection().getInputStream()))
        }
    }

    override fun onCleared() {
        executorService.shutdown()
        super.onCleared()
    }

    companion object {
        const val TAG = "ExecutorService"
    }

}