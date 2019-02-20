package com.phellipesilva.featuretwo.di

import com.phellipesilva.featuretwo.service.FeatureTwoService
import dagger.Module
import dagger.Provides
import io.appflate.restmock.RESTMockServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object TestFeatureTwoServiceModule {

    @Provides
    @JvmStatic
    @Singleton
    fun providesFeatureTwoService(): FeatureTwoService = Retrofit.Builder()
        .baseUrl(RESTMockServer.getUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FeatureTwoService::class.java)
}