package com.phellipesilva.daggerworkshop.di

import com.phellipesilva.daggerworkshop.service.MainService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ServiceModule {

    @Provides
    fun providesMainService(): MainService = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MainService::class.java)

}