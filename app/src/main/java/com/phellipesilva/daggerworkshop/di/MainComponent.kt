package com.phellipesilva.daggerworkshop.di

import com.phellipesilva.daggerworkshop.view.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [MainModule::class])
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}
