package com.phellipesilva.featuretwo.di

import android.content.Context
import com.phellipesilva.featuretwo.view.FeatureTwoActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [FeatureTwoServiceModule::class])
interface FeatureTwoComponent {

    fun inject(featureTwoActivity: FeatureTwoActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun featureTwoActivity(featureTwoActivity: FeatureTwoActivity): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): FeatureTwoComponent
    }
}