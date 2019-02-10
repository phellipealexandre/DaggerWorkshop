package com.phellipesilva.featuretwo.service

import com.phellipesilva.featuretwo.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal interface FeatureTwoService {

    @GET("/users")
    fun getSingleUser(@Query("id") id: Int): Call<List<User>>

}