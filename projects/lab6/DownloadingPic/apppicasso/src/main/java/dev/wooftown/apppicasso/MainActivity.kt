package dev.wooftown.apppicasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.squareup.picasso.Picasso
import dev.wooftown.apppicasso.databinding.ActivityMainBinding
import java.net.URL


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mainViewModel: MainViewModel by viewModels()
        binding.btnDownload.setOnClickListener {
            mainViewModel.downloadImage(URL(CAT))
        }
        binding.btnClear.setOnClickListener {
            mainViewModel.bitmapData.value = null
        }
        mainViewModel.bitmapData.observe(this) {
            binding.image.setImageBitmap(it)
        }

    }

    companion object {
        const val CAT = "https://static.educalingo.com/img/en/800/kitten.jpg"
    }

}