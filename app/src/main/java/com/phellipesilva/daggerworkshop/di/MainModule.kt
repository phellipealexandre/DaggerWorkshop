package com.phellipesilva.daggerworkshop.di

import com.phellipesilva.daggerworkshop.view.MainActivity
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

@Module
class MainModule @Inject constructor(private val mainActivity: MainActivity) {

    @Provides
    fun providesMainActivity(): MainActivity = mainActivity

    @Provides
    fun providesExecutor(): Executor = Executors.newSingleThreadExecutor()
}