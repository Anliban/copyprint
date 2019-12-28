package com.anliban.copyprint.util

import android.content.Context
import androidx.work.*
import com.anliban.copyprint.data.worker.SaveClipboardWorker

object WorkUtil {

    private val constraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
        .setRequiresCharging(false)
        .build()

    fun saveClipboard(context: Context, text: String) {
        val queue = OneTimeWorkRequestBuilder<SaveClipboardWorker>()
            .setConstraints(constraints)
            .setInputData(transformData(text))
            .build()
        WorkManager.getInstance(context).enqueue(queue)
    }

    private fun transformData(text: String): Data {
        return Data.Builder().apply {
            putString(WORK_INPUT_KEY, text)
        }.build()
    }
}