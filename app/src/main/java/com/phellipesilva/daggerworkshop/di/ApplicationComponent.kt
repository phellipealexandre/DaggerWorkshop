package com.phellipesilva.daggerworkshop.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class, ServiceModule::class])
interface ApplicationComponent {
    fun plusMainModule(mainModule: MainModule): MainComponent

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(applicationContext: Context): Builder
        fun build(): ApplicationComponent
    }
}