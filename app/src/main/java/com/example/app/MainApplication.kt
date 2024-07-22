package com.example.app

import android.app.Application
import android.os.Process
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        Thread.setDefaultUncaughtExceptionHandler(CatchAllHandler())
        appComponent = DaggerAppComponent.builder().inject(this).build()
    }

    internal class CatchAllHandler : Thread.UncaughtExceptionHandler {
        override fun uncaughtException(
            thread: Thread,
            exception: Throwable
        ) {
            try {
                val appVersion = BuildConfig.VERSION_NAME
                Log.e(
                    "APPLICATION CRASHED (v$appVersion) $thread / $exception",
                    exception.message ?: "Se ha producido un error inesperado"
                )
                Thread.sleep(2000)
                Process.killProcess(Process.myPid())
            } catch (ex: Throwable) {
                Log.e("CEPSA-STANDALONE", "APP-CRASH!!! Uncaught error $thread / $exception", exception)
                Log.e("CEPSA-STANDALONE", "ERROR-REPORTING!!! $ex", ex)
            }
        }
    }
}