package com.phellipesilva.featuretwo.di

import com.phellipesilva.featuretwo.service.FeatureTwoService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object FeatureTwoServiceModule {

    @Provides
    @JvmStatic
    @Singleton
    fun providesFeatureTwoService(): FeatureTwoService = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FeatureTwoService::class.java)
}