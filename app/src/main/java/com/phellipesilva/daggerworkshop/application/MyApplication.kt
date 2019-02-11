package com.phellipesilva.daggerworkshop.application

import android.app.Activity
import android.app.Application
import com.phellipesilva.daggerworkshop.di.*

class MyApplication : Application() {

    val mainComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationContext(this)
            .build()
    }
}

val Activity.injector get() = (application as MyApplication).mainComponent