package com.phellipesilva.daggerworkshop.application

import android.app.Activity
import android.app.Application
import com.phellipesilva.daggerworkshop.di.*
import com.phellipesilva.featuretwo.di.DaggerFeatureTwoComponent
import com.phellipesilva.featuretwo.di.FeatureTwoComponent
import com.phellipesilva.featuretwo.di.FeatureTwoComponentProvider
import com.phellipesilva.featuretwo.view.FeatureTwoActivity

class MyApplication : Application(), MainComponentProvider, FeatureTwoComponentProvider {

    override val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationContext(this)
            .build()
    }

    override fun providesFeatureTwoComponent(featureTwoActivity: FeatureTwoActivity): FeatureTwoComponent {
        return DaggerFeatureTwoComponent
            .builder()
            .featureTwoActivity(featureTwoActivity)
            .context(this)
            .build()
    }

}

val Activity.applicationInjector get() = (application as MainComponentProvider).applicationComponent
