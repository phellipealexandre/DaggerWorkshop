package com.phellipesilva.daggerworkshop.interactor

import com.phellipesilva.daggerworkshop.database.User
import com.phellipesilva.daggerworkshop.database.UserDAO
import com.phellipesilva.daggerworkshop.service.MainService
import dagger.Reusable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor
import javax.inject.Inject

@Reusable
class MainInteractor @Inject constructor(
    private val mainService: MainService,
    private val userDAO: UserDAO,
    private val executor: Executor
) {
    fun fetchAndStoreUsersFromServer(successCallback: (List<User>) -> (Unit)): Call<List<User>> {
        val call = mainService.getAllUsers()
        call.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                response.body()?.apply {
                    executor.execute { userDAO.saveUser(this) }
                    successCallback.invoke(this)
                }
            }

        })

        return call
    }

    fun fetchUserFromDatabase(callback: (List<User>) -> Unit) {
        executor.execute {
            val users = userDAO.getAllUsers()
            callback.invoke(users)
        }
    }

}

