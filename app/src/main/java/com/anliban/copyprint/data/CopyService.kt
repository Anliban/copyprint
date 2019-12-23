package com.anliban.copyprint.data

import android.app.Service
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.IBinder


class CopyService : Service() {

    private lateinit var clipboardManager: ClipboardManager

    private val clipboardListener = ClipboardManager.OnPrimaryClipChangedListener {
        val data = clipboardManager.primaryClip
        val text = data?.getItemAt(0)?.text
    }

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        clipboardManager.addPrimaryClipChangedListener(clipboardListener)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        super.onCreate()
        clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    }

    override fun onDestroy() {
        super.onDestroy()
        clipboardManager.removePrimaryClipChangedListener(clipboardListener)
    }
}