package com.anliban.copyprint.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build

class CopyBootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED) {
            startService(context)
        }
    }

    private fun startService(context: Context?) {
        val bootIntent = Intent(context, CopyService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context?.startForegroundService(bootIntent)
        } else {
            context?.startService(bootIntent)
        }
    }
}