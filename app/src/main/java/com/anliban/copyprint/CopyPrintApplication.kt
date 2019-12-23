package com.anliban.copyprint

import android.content.Context
import android.content.Intent
import android.os.Build
import com.anliban.copyprint.data.CopyService
import com.anliban.copyprint.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class CopyPrintApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        startService(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

    private fun startService(context: Context?) {
        val bootIntent = Intent(context, CopyService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            println("zzzdaf")
            startForegroundService(bootIntent)
        } else {
            println("feafew")
            startService(bootIntent)
        }
    }

}