package com.anliban.copyprint.data.worker

import com.anliban.copyprint.di.qualifier.WorkerKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface WorkerBindModule {

    @Binds
    @IntoMap
    @WorkerKey(SaveClipboardWorker::class)
    fun bindSaveClipboardWorker(factory: SaveClipboardWorker.Factory): WorkerCreator
}