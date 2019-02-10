package com.phellipesilva.featuretwo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.phellipesilva.featuretwo.R
import com.phellipesilva.featuretwo.business.BusinessClassB
import com.phellipesilva.featuretwo.business.HelperClass
import com.phellipesilva.featuretwo.interactor.FeatureTwoInteractor
import com.phellipesilva.featuretwo.model.User
import com.phellipesilva.featuretwo.presenter.FeatureTwoPresenter
import com.phellipesilva.featuretwo.service.FeatureTwoService
import com.phellipesilva.featuretwo.utils.ConnectionManager
import kotlinx.android.synthetic.main.activity_feature_two.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FeatureTwoActivity : AppCompatActivity() {

    private lateinit var featureTwoPresenter: FeatureTwoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_two)

        initPresenter()
        showNavigationIdToast()
        fetchUserDetails()
    }

    internal fun showUser(user: User) {
        textView.text = "This user named ${user.name} has an username ${user.username} and email ${user.email}"
    }

    internal fun showError() {
        textView.text = getString(R.string.error_msg)
    }

    private fun fetchUserDetails() {
        val userId = intent.getIntExtra("id", 0)
        featureTwoPresenter.fetchUserDetails(userId)
    }

    private fun showNavigationIdToast() {
        val navigationId = intent.getIntExtra("navigationId", 0)
        Toast.makeText(this, "Start Loading, navigation id: $navigationId", Toast.LENGTH_SHORT)
            .show()
    }

    private fun initPresenter() {
        val featureTwoService = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FeatureTwoService::class.java)

        val helperClass = HelperClass()
        val businessClassB = BusinessClassB(helperClass)
        val featureTwoInteractor = FeatureTwoInteractor(featureTwoService)
        val connectionManager = ConnectionManager(this)
        featureTwoPresenter = FeatureTwoPresenter(this, businessClassB, featureTwoInteractor, connectionManager)
    }
}
