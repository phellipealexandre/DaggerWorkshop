package com.phellipesilva.daggerworkshop.di

import android.content.Context
import androidx.room.Room
import com.phellipesilva.daggerworkshop.database.UserDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule(private val context: Context) {

    @Provides
    fun providesUserDAO() =
        Room.databaseBuilder(context, UserDatabase::class.java, "UserDatabase")
            .build()
            .getUserDAO()
}