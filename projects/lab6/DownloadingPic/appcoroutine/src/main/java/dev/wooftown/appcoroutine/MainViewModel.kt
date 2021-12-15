package dev.wooftown.appcoroutine

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL


class MainViewModel : ViewModel() {

    val bitmap: MutableLiveData<Bitmap> = MutableLiveData()

    fun downloadImage(url: URL) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d(TAG, "Sleeping 2sec")
            delay(2000)
            Log.d(TAG, "Downloading in ${Thread.currentThread()}")
            val pic = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            withContext(Dispatchers.Main){
                bitmap.value = pic
            }
        }

    }

    companion object {
        const val TAG = "Coroutines"
    }

}