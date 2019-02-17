package com.phellipesilva.daggerworkshop.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.phellipesilva.daggerworkshop.R
import com.phellipesilva.daggerworkshop.application.applicationInjector
import com.phellipesilva.daggerworkshop.database.User
import com.phellipesilva.daggerworkshop.di.DaggerMainComponent
import com.phellipesilva.daggerworkshop.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDependencies()

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

    private fun initDependencies() {
        DaggerMainComponent
            .builder()
            .applicationComponent(applicationInjector)
            .mainActivity(this)
            .build()
            .inject(this)
    }
}
