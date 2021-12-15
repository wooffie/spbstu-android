package dev.wooftown.executorservice

import android.app.Application
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MyApplication : Application() {
    val downloadThread : ExecutorService = Executors.newSingleThreadExecutor()
}