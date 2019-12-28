package com.anliban.copyprint

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.work.Configuration
import androidx.work.WorkManager
import com.anliban.copyprint.data.CopyService
import com.anliban.copyprint.data.worker.AppWorkerFactory
import com.anliban.copyprint.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class CopyPrintApplication : DaggerApplication() {

    @Inject
    lateinit var workerFactory: AppWorkerFactory

    override fun onCreate() {
        super.onCreate()
        startService(this)
        startWokrer()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

    private fun startService(context: Context?) {
        val bootIntent = Intent(context, CopyService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(bootIntent)
        } else {
            startService(bootIntent)
        }
    }

    private fun startWokrer() {
        //  val factory = DaggerAppComponent.factory()

        WorkManager.initialize(
            this,
            Configuration.Builder().setWorkerFactory(workerFactory).build()
        )
    }

}