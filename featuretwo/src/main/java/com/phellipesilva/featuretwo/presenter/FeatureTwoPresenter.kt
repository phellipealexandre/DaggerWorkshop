package com.phellipesilva.featuretwo.presenter

import com.phellipesilva.featuretwo.business.BusinessClassB
import com.phellipesilva.featuretwo.interactor.FeatureTwoInteractor
import com.phellipesilva.featuretwo.model.User
import com.phellipesilva.featuretwo.utils.ConnectionManager
import com.phellipesilva.featuretwo.view.FeatureTwoActivity
import retrofit2.Call
import javax.inject.Inject

class FeatureTwoPresenter @Inject constructor(
    private val featureTwoActivity: FeatureTwoActivity,
    private val businessClassB: BusinessClassB,
    private val featureTwoInteractor: FeatureTwoInteractor,
    private val connectionManager: ConnectionManager
) {

    private var fetchUserCall: Call<List<User>>? = null

    fun fetchUserDetails(id: Int) {
        if (connectionManager.isConnected() && businessClassB.returnTrue()) {
            fetchUser(id)
        } else {
            featureTwoActivity.showError()
        }
    }

    fun cancelRequest() {
        fetchUserCall?.cancel()
    }

    private fun fetchUser(id: Int) {
        fetchUserCall = featureTwoInteractor.fetchUserDetailsFromServer(id, {
            featureTwoActivity.showUser(it.first())
        }, {
            featureTwoActivity.showError()
        })
    }

}