package com.phellipesilva.featuretwo.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.phellipesilva.featuretwo.R
import com.phellipesilva.featuretwo.di.DaggerFeatureTwoComponent
import com.phellipesilva.featuretwo.model.User
import com.phellipesilva.featuretwo.presenter.FeatureTwoPresenter
import kotlinx.android.synthetic.main.activity_feature_two.*
import javax.inject.Inject

class FeatureTwoActivity : AppCompatActivity() {

    @Inject
    lateinit var featureTwoPresenter: FeatureTwoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_two)

        inject()
        fetchUserDetails()
    }

    override fun onDestroy() {
        super.onDestroy()
        featureTwoPresenter.cancelRequest()
    }

    internal fun showUser(user: User) {
        showNavigationIdToast()
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

    private fun inject() {
        DaggerFeatureTwoComponent
            .builder()
            .context(applicationContext)
            .featureTwoActivity(this)
            .build()
            .inject(this)
    }
}
