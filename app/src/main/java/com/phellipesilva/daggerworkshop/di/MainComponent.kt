package com.phellipesilva.daggerworkshop.di

import com.phellipesilva.daggerworkshop.view.MainActivity
import dagger.Component

@Component(modules = [MainModule::class, DatabaseModule::class, ServiceModule::class])
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}
