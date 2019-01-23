package com.phellipesilva.daggerworkshop.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface UserDAO {

    @Insert(onConflict = REPLACE)
    fun saveUser(users: List<User>)

    @Query("SELECT * FROM User")
    fun getAllUsers(): List<User>
}