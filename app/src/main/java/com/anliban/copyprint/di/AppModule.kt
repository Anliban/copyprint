package com.anliban.copyprint.di

import android.app.Application
import android.content.Context
import com.anliban.copyprint.CopyPrintApplication
import com.anliban.copyprint.data.db.CopyPrintDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(app: CopyPrintApplication): Context = app.applicationContext

    @Singleton
    @Provides
    fun provideApplication(): Application = CopyPrintApplication()

    @Singleton
    @Provides
    fun provideDb(context: Context) = CopyPrintDataBase.getInstance(context)

    @Singleton
    @Provides
    fun provideCopyDao(db: CopyPrintDataBase) = db.copyDao()
}