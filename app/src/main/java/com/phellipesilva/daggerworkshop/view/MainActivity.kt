package com.phellipesilva.daggerworkshop.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.phellipesilva.daggerworkshop.R
import com.phellipesilva.daggerworkshop.business.BusinessClassA
import com.phellipesilva.daggerworkshop.database.User
import com.phellipesilva.daggerworkshop.database.UserDatabase
import com.phellipesilva.daggerworkshop.interactor.MainInteractor
import com.phellipesilva.daggerworkshop.navigation.Navigator
import com.phellipesilva.daggerworkshop.presenter.MainPresenter
import com.phellipesilva.daggerworkshop.service.MainService
import com.phellipesilva.featuretwo.business.BusinessClassB
import com.phellipesilva.featuretwo.business.HelperClass
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()

        mainPresenter.getUserFromDatabase()

        swipeRefreshLayout.setOnRefreshListener {
            mainPresenter.updateUsersFromServer()
        }

    }

    fun showUsers(users: List<User>) {
        val mainAdapter = MainAdapter(this, users)
        mainAdapter.setOnUserClickListener { mainPresenter.navigatesToFeatureTwo(it) }
        recyclerView.adapter = mainAdapter

        swipeRefreshLayout.isRefreshing = false
    }

    private fun initPresenter() {
        val userDAO = Room.databaseBuilder(this, UserDatabase::class.java, "UserDatabase")
            .build()
            .getUserDAO()

        val mainService = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MainService::class.java)

        val navigator = Navigator(this)

        val helperClass = HelperClass()
        val classA = BusinessClassA(helperClass)
        val classB = BusinessClassB(helperClass)

        val mainInteractor = MainInteractor(mainService, userDAO, Executors.newSingleThreadExecutor())
        mainPresenter = MainPresenter(this, mainInteractor, navigator, classA, classB)
    }
}
