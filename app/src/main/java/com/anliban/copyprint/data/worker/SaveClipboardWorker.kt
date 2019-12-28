package com.anliban.copyprint.data.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import com.anliban.copyprint.data.db.dao.CopyDao
import com.anliban.copyprint.data.db.entity.CopyEntityImpl
import com.anliban.copyprint.util.WORK_INPUT_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class SaveClipboardWorker(
    context: Context,
    params: WorkerParameters,
    private val dao: CopyDao
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        withContext(Dispatchers.IO) {
            try {
                val content = inputData.getString(WORK_INPUT_KEY)

                content?.let {
                    val clipboard = CopyEntityImpl(id = 0, text = it, createdAt = Date().time)

                    dao.add(clipboard)
                    Result.success()
                }

            } catch (e: Throwable) {
                Result.failure()
            }

        }

        return Result.success()
    }

    class Factory @Inject constructor(
        private val dao: CopyDao
    ) : WorkerCreator {
        override fun create(appContext: Context, params: WorkerParameters): ListenableWorker {
            return SaveClipboardWorker(appContext, params, dao)
        }
    }

}