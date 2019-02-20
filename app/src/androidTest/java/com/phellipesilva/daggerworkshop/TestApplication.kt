package com.phellipesilva.daggerworkshop

import android.app.Application
import com.phellipesilva.daggerworkshop.di.ApplicationComponent
import com.phellipesilva.daggerworkshop.di.MainComponentProvider
import com.phellipesilva.daggerworkshop.di.DaggerTestApplicationComponent

class TestApplication: Application(), MainComponentProvider {

    override val applicationComponent: ApplicationComponent by lazy {
        DaggerTestApplicationComponent
            .builder()
            .applicationContext(this)
            .build()
    }
}