package com.phellipesilva.featuretwo.utils

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

class ConnectionManager @Inject constructor(private val context: Context) {

    fun isConnected(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

}