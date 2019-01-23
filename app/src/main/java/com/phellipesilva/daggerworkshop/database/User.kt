package com.phellipesilva.daggerworkshop.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class User(
    @PrimaryKey
    val id: Int,
    val name: String,
    val username: String,
    val email: String
)