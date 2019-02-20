package com.phellipesilva.daggerworkshop.di

import android.content.Context
import androidx.room.Room
import com.phellipesilva.daggerworkshop.database.UserDAO
import com.phellipesilva.daggerworkshop.database.UserDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object TestDatabaseModule {

    @Singleton
    @Provides
    @JvmStatic
    fun providesUserDAO(context: Context): UserDAO =
        Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java)
            .build()
            .getUserDAO()
}