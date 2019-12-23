package com.anliban.copyprint.di

import com.anliban.copyprint.CopyPrintApplication
import com.anliban.copyprint.domain.DomainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        ActivityBindingModule::class,
        AppModule::class,
        DomainModule::class
    ]
)
interface AppComponent : AndroidInjector<CopyPrintApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: CopyPrintApplication): AppComponent
    }
}