package com.phellipesilva.daggerworkshop.di

import com.phellipesilva.daggerworkshop.view.MainActivity
import dagger.BindsInstance
import dagger.Component

@MainActivityScope
@Component(modules = [MainModule::class], dependencies = [ApplicationComponent::class])
interface MainComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun mainActivity(mainActivity: MainActivity): Builder
        fun applicationComponent(applicationComponent: ApplicationComponent): Builder
        fun build(): MainComponent
    }
}
