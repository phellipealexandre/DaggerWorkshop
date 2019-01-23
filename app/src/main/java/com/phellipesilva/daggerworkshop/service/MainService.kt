package com.phellipesilva.daggerworkshop.service

import com.phellipesilva.daggerworkshop.database.User
import retrofit2.Call
import retrofit2.http.GET

interface MainService {

    @GET("users")
    fun getRates(): Call<List<User>>
}