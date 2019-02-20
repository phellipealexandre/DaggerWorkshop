package com.phellipesilva.featuretwo.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestFeatureTwoServiceModule::class])
interface TestFeatureTwoComponent: FeatureTwoComponent {

    @Component.Builder
    interface Builder: FeatureTwoComponent.Builder
}