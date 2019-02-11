package com.phellipesilva.daggerworkshop.di

import android.content.Context
import androidx.room.Room
import com.phellipesilva.daggerworkshop.database.UserDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {

    @Singleton
    @Provides
    @JvmStatic
    fun providesUserDAO(context: Context) =
        Room.databaseBuilder(context, UserDatabase::class.java, "UserDatabase")
            .build()
            .getUserDAO()
}