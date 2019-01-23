package com.phellipesilva.daggerworkshop.presenter

import com.phellipesilva.daggerworkshop.business.BusinessClassA
import com.phellipesilva.daggerworkshop.business.BusinessClassB
import com.phellipesilva.daggerworkshop.database.User
import com.phellipesilva.daggerworkshop.interactor.MainInteractor
import com.phellipesilva.daggerworkshop.navigation.Navigator
import com.phellipesilva.daggerworkshop.view.MainActivity

class MainPresenter(
    private val mainActivity: MainActivity,
    private val mainInteractor: MainInteractor,
    private val navigator: Navigator,
    private val businessClassA: BusinessClassA,
    private val businessClassB: BusinessClassB
) {
    fun updateUsersFromServer() {
        mainInteractor.fetchAndStoreUsersFromServer {
            mainActivity.showUsers(it)
        }
    }

    fun getUserFromDatabase() {
        mainInteractor.fetchUserFromDatabase {
            mainActivity.showUsers(it)
        }
    }

    fun navigatesToFeatureTwo(user: User) {
        val randomId = businessClassA.generateRandomFromUser(user)
        val processedRandomId = businessClassB.doNothing(randomId)
        navigator.navigateToFeatureTwo(user, processedRandomId)
    }
}