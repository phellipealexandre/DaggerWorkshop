package com.phellipesilva.daggerworkshop.di

import dagger.Component

@Component(modules = [DatabaseModule::class, ServiceModule::class])
interface ApplicationComponent {
    fun plusMainModule(mainModule: MainModule): MainComponent
}