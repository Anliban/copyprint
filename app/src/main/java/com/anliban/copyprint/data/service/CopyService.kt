package com.anliban.copyprint.data.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.anliban.copyprint.util.ClipboardProvider
import com.anliban.copyprint.util.WorkUtil
import dagger.android.AndroidInjection
import javax.inject.Inject

class CopyService : Service() {

    @Inject
    lateinit var clipboardProvider: ClipboardProvider

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        clipboardProvider.bindDetect { WorkUtil.saveClipboard(applicationContext, it) }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        AndroidInjection.inject(this)
        super.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        clipboardProvider.unBindDetect()
    }
}