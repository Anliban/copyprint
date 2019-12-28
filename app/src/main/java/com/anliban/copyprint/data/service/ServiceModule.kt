package com.anliban.copyprint.data.service

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServiceModule {

    @ContributesAndroidInjector
    abstract fun bindCopyService(): CopyService
}