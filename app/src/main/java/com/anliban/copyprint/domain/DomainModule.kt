package com.anliban.copyprint.domain

import com.anliban.copyprint.data.db.dao.CopyDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    fun provideMainUseCase(repository: MainRepository): MainUseCase = MainUseCase(repository)

    @Singleton
    @Provides
    fun provideMainRepository(dao: CopyDao): MainRepository = MainRepositoryImpl(dao)
}