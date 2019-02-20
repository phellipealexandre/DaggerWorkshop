package com.phellipesilva.daggerworkshop.di

import com.phellipesilva.daggerworkshop.service.MainService
import dagger.Module
import dagger.Provides
import io.appflate.restmock.RESTMockServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object TestServiceModule {

    @Singleton
    @Provides
    @JvmStatic
    fun providesMainService(): MainService = Retrofit.Builder()
        .baseUrl(RESTMockServer.getUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MainService::class.java)
}