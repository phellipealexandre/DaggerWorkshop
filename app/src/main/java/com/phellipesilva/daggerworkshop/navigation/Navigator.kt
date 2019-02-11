package com.phellipesilva.daggerworkshop.navigation

import android.content.Intent
import com.phellipesilva.daggerworkshop.view.MainActivity
import com.phellipesilva.featuretwo.view.FeatureTwoActivity
import dagger.Reusable
import javax.inject.Inject

@Reusable
class Navigator @Inject constructor(private val mainActivity: MainActivity) {

    fun navigateToFeatureTwo(id: Int, navigationId: Int) {
        val intent = Intent(mainActivity, FeatureTwoActivity::class.java)
        intent.putExtra("id", id)
        intent.putExtra("navigationId", navigationId)
        mainActivity.startActivity(intent)
    }
}