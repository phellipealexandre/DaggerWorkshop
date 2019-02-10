package com.phellipesilva.daggerworkshop.di

import com.phellipesilva.daggerworkshop.presenter.MainPresenter
import dagger.Component

@Component(modules = [MainModule::class])
interface MainComponent {
    fun getMainPresenter(): MainPresenter
}
