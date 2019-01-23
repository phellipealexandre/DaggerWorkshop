package com.phellipesilva.daggerworkshop.navigation

import android.content.Context
import android.content.Intent
import com.phellipesilva.daggerworkshop.database.User
import com.phellipesilva.featuretwo.view.FeatureTwoActivity

class Navigator(
    private val context: Context
) {

    fun navigateToFeatureTwo(user: User, id: Int) {
        val intent = Intent(context, FeatureTwoActivity::class.java)
        intent.putExtra("user", user.name)
        intent.putExtra("id", id)
        context.startActivity(intent)
    }
}