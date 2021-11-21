package dev.wooftown.apppicasso

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.net.URL


class MainViewModel : ViewModel() {

    val bitmapData: MutableLiveData<Bitmap> = MutableLiveData()

    fun downloadImage(url: URL) {
        Picasso.get().load(url.toString()).into(
            object : Target {
                override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                    bitmapData.postValue(bitmap)
                }

                override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {}
                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {}
            }
        )

    }

}