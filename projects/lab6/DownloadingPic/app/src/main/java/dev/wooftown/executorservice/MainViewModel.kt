package dev.wooftown.executorservice

import android.annotation.SuppressLint
import android.app.Application
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.net.URL
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class MainViewModel(application: Application) : AndroidViewModel(application) {

    val bitmap: MutableLiveData<Bitmap> = MutableLiveData()

    private val context = getApplication<MyApplication>()
    private val executorService: ExecutorService = context.downloadThread

    fun downloadImage(url: URL) {
        executorService.execute {
            Log.d(TAG, "Sleeping 5sec")
            Thread.sleep(5000)
            Log.d(TAG, "Downloading in ${Thread.currentThread()}")
            bitmap.postValue(BitmapFactory.decodeStream(url.openConnection().getInputStream()))
        }
    }

    companion object {
        const val TAG = "ExecutorService"
    }

}