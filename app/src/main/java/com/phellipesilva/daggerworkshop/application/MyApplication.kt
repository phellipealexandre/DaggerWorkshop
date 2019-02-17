package com.phellipesilva.daggerworkshop.application

import android.app.Activity
import android.app.Application
import com.phellipesilva.daggerworkshop.di.*

class MyApplication : Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationContext(this)
            .build()
    }
}

val Activity.applicationInjector get() = (application as MyApplication).applicationComponent