package com.phellipesilva.daggerworkshop.di

import android.content.Context
import androidx.room.Room
import com.phellipesilva.daggerworkshop.business.BusinessClassA
import com.phellipesilva.daggerworkshop.database.UserDAO
import com.phellipesilva.daggerworkshop.database.UserDatabase
import com.phellipesilva.daggerworkshop.interactor.MainInteractor
import com.phellipesilva.daggerworkshop.navigation.Navigator
import com.phellipesilva.daggerworkshop.presenter.MainPresenter
import com.phellipesilva.daggerworkshop.service.MainService
import com.phellipesilva.daggerworkshop.view.MainActivity
import com.phellipesilva.featuretwo.business.BusinessClassB
import com.phellipesilva.featuretwo.business.HelperClass
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors

@Module
class MainModule(private val mainActivity: MainActivity) {

    @Provides
    fun providesContext(): Context = mainActivity

    @Provides
    fun providesMainActivity(): MainActivity = mainActivity

    @Provides
    fun providesUserDAO(context: Context) =
        Room.databaseBuilder(context, UserDatabase::class.java, "UserDatabase")
            .build()
            .getUserDAO()

    @Provides
    fun providesMainService(): MainService = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MainService::class.java)

    @Provides
    fun providesNavigator(context: Context) = Navigator(context)

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