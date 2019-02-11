package com.phellipesilva.daggerworkshop.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class, ServiceModule::class])
interface ApplicationComponent {
    fun plusMainModule(mainModule: MainModule): MainComponent
}