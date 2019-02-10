package com.phellipesilva.daggerworkshop.di

import com.phellipesilva.daggerworkshop.presenter.MainPresenter
import dagger.Component

@Component(modules = [MainModule::class, DatabaseModule::class, ServiceModule::class])
interface MainComponent {
    fun getMainPresenter(): MainPresenter
}
