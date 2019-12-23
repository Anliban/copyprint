package com.anliban.copyprint.di

import com.anliban.copyprint.di.qualifier.ActivityScoped
import com.anliban.copyprint.ui.MainActivity
import com.anliban.copyprint.ui.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class]
    )
    internal abstract fun mainActivity(): MainActivity

}