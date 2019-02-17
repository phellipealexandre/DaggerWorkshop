package com.phellipesilva.daggerworkshop.di

import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

@Module
class MainModule @Inject constructor() {

    @Provides
    fun providesExecutor(): Executor = Executors.newSingleThreadExecutor()
}