package com.phellipesilva.featuretwo.presenter

import com.phellipesilva.featuretwo.business.BusinessClassB
import com.phellipesilva.featuretwo.interactor.FeatureTwoInteractor
import com.phellipesilva.featuretwo.utils.ConnectionManager
import com.phellipesilva.featuretwo.view.FeatureTwoActivity
import javax.inject.Inject

class FeatureTwoPresenter @Inject constructor(
    private val featureTwoActivity: FeatureTwoActivity,
    private val businessClassB: BusinessClassB,
    private val featureTwoInteractor: FeatureTwoInteractor,
    private val connectionManager: ConnectionManager
) {

    fun fetchUserDetails(id: Int) {
        if (connectionManager.isConnected() && businessClassB.returnTrue()) {
            fetchUser(id)
        } else {
            featureTwoActivity.showError()
        }
    }

    private fun fetchUser(id: Int) {
        featureTwoInteractor.fetchUserDetailsFromServer(id, {
            featureTwoActivity.showUser(it.first())
        }, {
            featureTwoActivity.showError()
        })
    }

}