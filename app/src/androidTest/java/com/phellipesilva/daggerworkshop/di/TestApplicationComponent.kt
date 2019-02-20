package com.phellipesilva.daggerworkshop.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestServiceModule::class, TestDatabaseModule::class])
interface TestApplicationComponent: ApplicationComponent {

    @Component.Builder
    interface Builder : ApplicationComponent.Builder
}