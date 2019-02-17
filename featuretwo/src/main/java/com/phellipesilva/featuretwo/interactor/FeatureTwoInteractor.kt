package com.phellipesilva.featuretwo.interactor

import com.phellipesilva.featuretwo.model.User
import com.phellipesilva.featuretwo.service.FeatureTwoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class FeatureTwoInteractor @Inject constructor(private val featureTwoService: FeatureTwoService) {

    fun fetchUserDetailsFromServer(id: Int, successCallback: (List<User>) -> (Unit), errorCallback: () -> (Unit)): Call<List<User>> {
        val call = featureTwoService.getSingleUser(id)
        call.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                errorCallback.invoke()
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                response.body()?.apply {
                    successCallback.invoke(this)
                }
            }

        })

        return call
    }
}