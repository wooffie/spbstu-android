package dev.wooftown.executorservice


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dev.wooftown.executorservice.databinding.ActivityMainBinding
import java.net.URL

// adb emu network speed gsm
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
            mainViewModel.bitmap.value = null
        }
        mainViewModel.bitmap.observe(this) {
            binding.image.setImageBitmap(it)
        }

    }

    companion object {
        const val CAT = "https://static.educalingo.com/img/en/800/kitten.jpg"
    }

}