package dev.wooftown.appexecutorservice

import android.app.Application
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MyApplication : Application() {
    val watchPool : ExecutorService = Executors.newSingleThreadExecutor()
}