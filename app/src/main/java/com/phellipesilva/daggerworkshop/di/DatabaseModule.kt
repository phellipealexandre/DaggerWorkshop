package com.phellipesilva.daggerworkshop.di

import android.content.Context
import androidx.room.Room
import com.phellipesilva.daggerworkshop.database.UserDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesUserDAO(context: Context) =
        Room.databaseBuilder(context, UserDatabase::class.java, "UserDatabase")
            .build()
            .getUserDAO()
}