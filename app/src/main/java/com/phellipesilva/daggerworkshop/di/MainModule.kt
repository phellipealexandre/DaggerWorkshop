package com.phellipesilva.daggerworkshop.di

import com.phellipesilva.daggerworkshop.business.BusinessClassA
import com.phellipesilva.daggerworkshop.database.UserDAO
import com.phellipesilva.daggerworkshop.interactor.MainInteractor
import com.phellipesilva.daggerworkshop.navigation.Navigator
import com.phellipesilva.daggerworkshop.presenter.MainPresenter
import com.phellipesilva.daggerworkshop.service.MainService
import com.phellipesilva.daggerworkshop.view.MainActivity
import com.phellipesilva.featuretwo.business.BusinessClassB
import com.phellipesilva.featuretwo.business.HelperClass
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors

@Module
class MainModule(private val mainActivity: MainActivity) {

    @Provides
    fun providesMainActivity(): MainActivity = mainActivity

    @Provides
    fun providesNavigator(mainActivity: MainActivity) = Navigator(mainActivity)

    @Provides
    fun providesHelperClass() = HelperClass()

    @Provides
    fun providesBusinessClassA(helperClass: HelperClass) = BusinessClassA(helperClass)

    @Provides
    fun providesBusinessClassB(helperClass: HelperClass) = BusinessClassB(helperClass)

    @Provides
    fun providesExecutor(): Executor = Executors.newSingleThreadExecutor()

    @Provides
    fun providesMainInteractor(mainService: MainService, userDAO: UserDAO, executor: Executor) =
        MainInteractor(mainService, userDAO, executor)

    @Provides
    fun providesMainPresenter(
        mainActivity: MainActivity,
        mainInteractor: MainInteractor,
        navigator: Navigator,
        businessClassA: BusinessClassA,
        businessClassB: BusinessClassB
    ) =
        MainPresenter(mainActivity, mainInteractor, navigator, businessClassA, businessClassB)
}